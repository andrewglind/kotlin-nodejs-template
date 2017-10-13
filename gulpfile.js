var fs = require('fs');
var gulp = require('gulp');
var del = require('del');
var exec = require('child_process').exec;

var build = function(tier, moduleKind) {
 return new Promise(function(resolve, reject) {
  exec('kotlinc-js src/' + tier + ' -module-kind '+ moduleKind + ' -output out/' + tier + '.js', function(err, stdout, stderr) {
   if(err != null) {
    console.error(stderr);
    reject(err);
   } else {
    resolve();
   }
  });
 })
}

gulp.task('clean', function() {
 return del(['out', 'server.js', 'public/js/**/*']);
});

gulp.task('build:client', ['clean'], function() {
 return build('client', 'plain');
});

gulp.task('build:server', ['clean'], function() {
 return build('server', 'commonjs');
});

gulp.task('deploy:client', ['build:client'], function() {
 gulp.src('out/client.js').pipe(gulp.dest('public/js'));
 gulp.src('node_modules/kotlin/kotlin.js').pipe(gulp.dest('public/lib'));
});

gulp.task('deploy:server', ['build:server'], function() {
 gulp.src('out/server.js').pipe(gulp.dest('./'));
});

gulp.task('default', ['clean', 'build:client', 'build:server', 'deploy:client', 'deploy:server']);

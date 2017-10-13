Kotlin on Node.js
=================

This project intends to be a bootstrap for [Kotlin](http://kotlinlang.org) development on Node.js.

You will need to install [Node.js](http://nodejs.org), and [cURL](https://curl.haxx.se).

I suggest you use [SDKMAN](http://sdkman.io) to manage the Kotlin install.

To install SDKMAN and Kotlin:

`curl -s "https://get.sdkman.io" | bash`

open a new terminal:

`sdk install kotlin`

To build, issue the following commands:

`npm install -g gulp-cli`

`npm install`

`gulp`

To run, issue the following command:

`node server.js`

By default the application will start on port 3000. You can specify a different port with the following command:

`node server.js port=<port>`

Have fun!

const clone = require('nodegit').Clone;
const rimraf = require('rimraf');
const replace = require('replace');
const fs = require("fs")

const TEMP_PATH = __dirname + "/tmp";
const DEST_PATH = __dirname + "/kotlin";
const url = "https://github.com/Tyrbok/Android-Starter-Kotlin.git";

clone(url, TEMP_PATH)
    .then(function (repo) {
        console.log("Clone project from: " + url)
        console.log("Temp Path: " + TEMP_PATH)

        replace({
            regex: 'org.onepointzero.androidstarterkotlin',
            replacement: '<%= packageName %>',
            paths: [TEMP_PATH + '/app'],
            recursive: true,
            silent: true
        });
        
        replace({
            regex: 'Android Starter Kotlin',
            replacement: '<%= projectName %>',
            paths: [TEMP_PATH + '/app'],
            recursive: true,
            silent: true
        });

        console.log("Rename .gitignore");
        fs.renameSync(TEMP_PATH + "/.gitignore", TEMP_PATH + "/gitignore");
        fs.renameSync(TEMP_PATH + "/app/.gitignore", TEMP_PATH + "/app/gitignore");

        console.log("Remove .git from " + TEMP_PATH);
        rimraf.sync(TEMP_PATH + "/.git");

        console.log("Move to dest path: " + DEST_PATH);
        rimraf.sync(DEST_PATH);
        fs.renameSync(TEMP_PATH, DEST_PATH);


        console.log("Done.");
    })
    .catch(function (err) {
        console.log(err);
    });
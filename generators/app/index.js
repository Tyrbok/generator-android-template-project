'use strict';
const Generator = require('yeoman-generator');
const chalk = require('chalk');
const yosay = require('yosay');
const mkdirp = require('mkdirp');

module.exports = class extends Generator {
  prompting() {
    this.log(yosay(
      'Welcome to the primo ' + chalk.red('generator-android-template-project') + ' generator!'
    ));

    const prompts = [
      {
        type: 'list',
        name: 'lang',
        message: 'Application Language',
        choices: ['Java', 'Kotlin']
      },
      {
        name: 'projectName',
        message: 'Project Name',
        default: 'Hello-Starter'
      },
      {
        name: 'packageName',
        message: 'Package Name',
        default: 'org.onepointzero.starter'
      }
    ];

    return this.prompt(prompts).then(props => {
      // To access props later use this.props.someAnswer;
      this.props = props;
    });
  }

  writing() {
    var appLanguage = this.props.lang;

    var appFolder = (appLanguage === 'Java') ? 'java' : 'kotlin';
    var appBasePagackageName = (appLanguage === 'Java') ? 'androidstarterjava' : 'androidstarterkotlin';
    var packageDir = this.props.packageName.replace(/\./g, '/');

    var projectFolder = this.props.projectName;

    mkdirp.sync(projectFolder);
    process.chdir(projectFolder);

    mkdirp.sync('app');
    mkdirp.sync('app/src/main/java/' + packageDir);
    mkdirp.sync('app/src/main/java/res/' + packageDir);

    mkdirp.sync('app/src/test/java/' + packageDir);
    mkdirp.sync('app/src/androidTest/java/' + packageDir);

    mkdirp.sync('app/src/main/assets');

    var appPath = this.sourceRoot() + '/' + appFolder + '/';

    this.fs.copy(appPath + 'gitignore', '.gitignore');
    this.fs.copy(appPath + 'build.gradle', 'build.gradle');
    this.fs.copy(appPath + 'gradle.properties', 'gradle.properties');
    this.fs.copy(appPath + 'gradlew', 'gradlew');
    this.fs.copy(appPath + 'gradlew.bat', 'gradlew.bat');
    this.fs.copy(appPath + 'settings.gradle', 'settings.gradle');
    this.fs.copy(appPath + 'app/gitignore', 'app/.gitignore');

    this.fs.copy(appPath + 'app/proguard-rules.pro', 'app/proguard-rules.pro');

    this.fs.copy(appPath + 'gradle', 'gradle');

    this.fs.copyTpl(appPath + 'app/build.gradle', 'app/build.gradle', this.props);
    this.fs.copyTpl(appPath + 'README.md', 'README.md', this.props);
    this.fs.copyTpl(appPath + 'app/src/main/AndroidManifest.xml', 'app/src/main/AndroidManifest.xml', this.props);

    this.fs.copyTpl(appPath + 'app/src/main/java/org/onepointzero/' + appBasePagackageName, 'app/src/main/java/' + packageDir, this.props);
    this.fs.copyTpl(appPath + 'app/src/androidTest/java/org/onepointzero/' + appBasePagackageName, 'app/src/androidTest/java/' + packageDir, this.props);
    this.fs.copyTpl(appPath + 'app/src/test/java/org/onepointzero/' + appBasePagackageName, 'app/src/test/java/' + packageDir, this.props);

    this.fs.copyTpl(appPath + 'app/src/main/res/layout', 'app/src/main/res/layout', this.props);
    this.fs.copyTpl(appPath + 'app/src/main/res/values', 'app/src/main/res/values', this.props);

    this.fs.copy(appPath + 'app/src/main/res/mipmap-hdpi', 'app/src/main/res/mipmap-hdpi');
    this.fs.copy(appPath + 'app/src/main/res/mipmap-mdpi', 'app/src/main/res/mipmap-mdpi');
    this.fs.copy(appPath + 'app/src/main/res/mipmap-xhdpi', 'app/src/main/res/mipmap-xhdpi');
    this.fs.copy(appPath + 'app/src/main/res/mipmap-xxhdpi', 'app/src/main/res/mipmap-xxhdpi');
    this.fs.copy(appPath + 'app/src/main/res/mipmap-xxxhdpi', 'app/src/main/res/mipmap-xxxhdpi');
  }
};

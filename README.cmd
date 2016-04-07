/**
 * 环境：Android Studio + Gradle
 * 通过Robolectric + Junit实现Android单元测试
 * eg：新建 一个Android 项目( RobolectricDemoTest )该项目界面显示了一个textview和一个button，点击button可以改变textview所显示的文字
 */
 
 Instrumentation与Roboletric都是针对Android进行单元测试的框架，前者在执行case时是以Android JUnit的方式运行，
 因此必须在真实的Android环境中运行（模拟器或者真机），而后者则是以Java Junit的方式运行，这里就脱离了对 Android 环境的依赖，
 而可以直接将case在JVM中运行，因此很适合将Roboletric用于Android的测试驱动开发（TDD）。
 
 /**
 * Created by anyang on 2016/4/6.
 * 配置 RobolectricDemoTest/build.gradle：
 buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:1.5.0'

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
 }

 allprojects {
    repositories {
        jcenter()
    }
 }

 task clean(type: Delete) {
    delete rootProject.buildDir
 }


 // maven支持
 subprojects {

    repositories {
        maven { url "https://oss.sonatype.org/content/repositories/snapshots" }
        mavenLocal()
        mavenCentral()
    }
 }
 * 配置 app/build.gradle：
 apply plugin: 'com.android.application'

 // API23目前还不支持robolectric测试
 android {
    compileSdkVersion 22
    buildToolsVersion "22.0.1"

    defaultConfig {
        applicationId "com.example.anyang.robolectricdemotest"
        minSdkVersion 16
        targetSdkVersion 19
        versionCode 1
        versionName "1.0"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
 }

 dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    testCompile 'junit:junit:4.12'
    compile 'com.android.support:appcompat-v7:22.0.0'
    // 添加测试依赖
    testCompile "org.assertj:assertj-core:1.7.0"
    testCompile "org.robolectric:robolectric:3.0"
 }

 * 删除项目创建时系统自动生成的ApplicationTest测试文件，选择要进行测试的文件快速创建测试类（注意选择Junit4），例如：MainActivityTest
 * 编写测试代码
 * 配置 Build Variants：打开Build Variants视图界面，将Test Artifact选择为Unit Tests
 * 添加依赖：打开Gradle视图界面，点击刷新添加依赖
 * 完成测试：打开gradle面板，执行app--tasks--verification--testDebug，点击test文件右键运行测试，测试结果可在projectname\app\build\reports\tests\debug\index.html文件中通过网页查看
 */
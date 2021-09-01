# Project: SoftWhere (App Development)

## Description

SoftWhere is an android application designed for beginers and aspirants that wish to pursue a career in **Software Development.**   

It contains three sets of features:  
**1. Programming language progress tracker-** Programming Languages are the foundations of Software Development. This section provides the user with a list of 
programming languages along with its description. At first, all the languages would be *"UNSEEN"* by the user. Three radio buttons are provided beside the language. 
First one would mark the language as *UNSEEN* with a grey background, second one would mark the language as *START* with a yellow background and the third one would 
mark the language as *COMPLETED* with a green background. The section also has a search bar for search programming languages by title.  

**2. Information Bank-** "Information is only useful when it can be understood". This sections contains various cards containing description about the various 
sub-disciplines of Software Development such as Web Development, frontend, backend, full stack. The information will be consolidated in such a such that a beginer 
in programming would be able to understand it but will also provide essential keywords necessary for learning that topic. An alternative purpose of this section is 
to remove misconceptions regarding these sub-disciplines that might exist due to reasons such as over-popularity.  

**3. 'Various Jobs' section-** Incentives are an essential part of learning when one commits months of his/her time into learning that thing. In the case of Software 
Development where one has to not only tackle numerous open-ended problems, but also come up with creative solutions, strong incentives become an essential factor in 
commitment. For this reason, this section contains various job offerenings collected from various websites such as linkeIn, indeed, etc, along with its description, 
qualifications and avarage offered salary. The monetary incentives provided to Software Developers are usually much higher than most other jobs and this should be 
able to provide some incentive other that self's passion to the user.

The size of this app is around 4.64MB.

## Prerequisites

* The version 1.0 requires a minimum API Level of 26 (Android Oreo) to run this app.
* The build gradle(app) for this app is:
 
 ```
 apply plugin: 'com.android.application'

android {
    compileSdkVersion 29

    android {
        compileOptions {
            sourceCompatibility JavaVersion.VERSION_1_8
            targetCompatibility JavaVersion.VERSION_1_8
        }
    }

    defaultConfig {
        applicationId "com.example.softwhere"
        minSdkVersion 24
        targetSdkVersion 29
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    implementation fileTree(dir: "libs", include: ["*.jar"])
    implementation 'androidx.appcompat:appcompat:1.3.1'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.0'
    implementation 'androidx.cardview:cardview:1.0.0'
    implementation 'androidx.recyclerview:recyclerview:1.2.1'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'

    implementation 'com.github.bumptech.glide:glide:4.12.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'
    implementation 'com.google.code.gson:gson:2.8.8'
}
 ``` 
 * The extra dependcies as mentioned above are [Glide](https://github.com/bumptech/glide) and [Gson](https://github.com/google/gson).
 * Other than google() and jcenter(), one extra repository is used called mavencentral() which is used to integrate Glide into the project.

## Installation

1. Download this [.apk file](https://drive.google.com/file/d/14eXM19CXHwr3lFwGQziVu8wO4VkuBRvV/view?usp=sharing) from my google drive folder (Only people from 'Indian institute of Technology Tirupati' mailing list can access this file). Preferrable to download this in your personal computer.
2. 

## Contact

Sagar Singh  
cs19b038@iittp.ac.in
Indian Institute of Technology, Tirupati.

## P.S.
The main aim for this project was to provide affordable techinal education. In order to achieve this, the application is **free of charge**. During the early stages, 
everyone struggles in finding a direction or a starting point as random Internet searches either provides useless information or very technical infromation, cited 
from various differnet websites, which makes finding adequate information very difficult escpecially when one does not even know the necessary keywords to use for 
their searches. My app provides a **starting location, direction, map, paths and an end result** for its user so that he/she can choose their ideal career in the 
discipline of **Software Development.**

If I had to use an example to describe this app, using modern trends of eduaction (online courses), I would say that this app is not an online course portal but a guide 
that would help you *choose* and *judge* a good online course.

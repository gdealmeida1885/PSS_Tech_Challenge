#### PSS Tech Challenge
This repo stores the PSS Tech challenge and contains three simple Login test scenarios.

The idea here is to show how I would use and automate some of the PSS tests with Kotlin

### File Tree
The project is organized on the following way:
- Data: stores all de data classes used on the project
- Screens: stores all the PageScreens mapped
- Utils: stores random utils, like Timeouts Enum
- Capabilities and DeviceCaps: files in which all the device caps logic is store
- Resources: stores the app apk
- Test: stores the test suites
````
└── main/
├── kotlin/
│   ├── data/
│   │   └── UserData.kt
│   ├── screens/
│   │   ├── BaseScreen.kt
│   │   ├── LoginScreen.kt
│   │   └── HomeScreen.kt
│   ├── utils/
│   │   └── Timeouts.kt
│   ├── Capabilitties.kt
│   └── DeviceCaps.kt
├── resources/
│   └── scruff_app.apk
└── test/
└── kotlin/
└── LoginTest.kt
````

### Dependencies
To run this project you must have
* Java and Kotlin installed
* Appium
* Maven
* Android Studio
* Android physical or emulated device
* ADB

### Install Java / Kotlin dependencies
On the root folder of the project, run

```mvn clean install```

#### How to configure the project
On the ```DeviceCaps.kt``` file, change the ```deviceName``` capability to your device caps.
To know which value to insert, run on your terminal

``` adb devices```

### Running the project
Execute on your terminal the command bellow, to start appium server

``` appium ```

On a new terminal window, within the root folder of the project, run

``` mvn clean -Dtest=LoginTest test ```
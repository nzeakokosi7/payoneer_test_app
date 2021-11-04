# PayoneerTestApp

A Native Android (JAVA) App DEMO challenge for Payoneer.

|  A brief preview          |  
:-------------------------:|
![](https://github.com/nzeakokosi7/payoneer_test_app/blob/master/app/src/main/res/assets/demo.gif)

## Getting Started
This app was designed using the MVVM architecture.
I also adapted the UI convention of <br/> one Activity (MainActivity), multiple fragments using the Android Navigation Component.

I used retrofit for networking, Gson for object mapping while using OkhttpClient for cache  <br/>  control. I wrote a custom Retrofit Callback class to enable me handle errors such as  <br/>  SocketTimeoutException, UnknownHostException, ConnectException, JSONException,  <br/>  IOException and other standard network errors properly.

For better user experience, a third party loader libary <br/> ('com.elyeproj.libraries:loaderviewlibrary:2.0.0') to serve as a placeholder while making network calls.

### Details of the project structure explained below

- /app <br/>
  <span style="font-size:15px; color:grey"> #This is where all the application's directories are contained. </span>
    - /adapters
      <br/> <span style="font-size:15px; color:grey"> #This directory contains the adapter for binding data to the recycler view. </span>

    - /dao <br/>
      <span style="font-size:15px; color:grey">  # this directory contains the ApiInterface for retrofit. </span>

    - /models
      <br/> <span style="font-size:15px; color:grey"> # This directory contains all the POJO classes.</span>

    - /repositories <br/>
      <span style="font-size:15px; color:grey"> # This directory contains the repositories which abstracts data from the ApiInterface <br/> and feeds to respective view models.

    - /ui
      <br/> <span style="font-size:15px; color:grey"> # This directory contains all UI modules like each module contained within is a subdirectory <br/> containing a fragment and its view model.
      </span>

    - /utils
      <br/> <span style="font-size:15px; color:grey"> This directory contains helper classes like the Retrofit service class and the Retrofit <br/> callback class. </span>



- MainActivity.java <br/>
  <span style="font-size:15px; color:grey"># Main activity class file.

- PayoneerTestApp.java <br/>
  <span style="font-size:15px; color:grey"># Main application file which extends the Application class.

- SplashActivity.java <br/>
  <span style="font-size:15px; color:grey"># Splash Screen activity for earlier android Os versions. <br/>NB: Recent android versions use the app theme and the roundIcon as a default splash screen.
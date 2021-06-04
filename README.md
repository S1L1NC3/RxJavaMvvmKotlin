<h2>Summary</h2>
Hello,

Here is the task that you wanted from me according to requirements, tried to work with small commits much as I can so it will be easier to track. Instead of using setValue(), I prefer 
postValue() reason to that setValue() has to be called in main thread. Instead of (For ex. component.text = object.firs_name), I used Data Binding all view, so it removes boiler plate code
from ViewHolder. 


<h2>3rd Party Libraries</h2>
<ul>
<li><b>Retrofit:</b> Added & Used for REST API connections </li> 
<li><b>GSON:</b> Added for serializing API response from Retrofit, also used for SharedPreferences offline storage </li>
<li><b>Glide:</b> Implementation Added (Not Used Yet) </li>
<li><b>SwipeRefreshLayout:</b> Added working </li>
<li><b>RxJava & RxAndroid:</b> Added and observed potential outcomes </li>
</ul>


<h2>Technical Stuff</h2>
<ul>
<li><b>Target Pattern:</b> MVVM </li>
<li><b>minSdkVersion:</b> 23 </li>
<li><b>targetSdkVersion:</b> 30 (Android 11) </li>
<li><b>versionCode:</b> 1 </li>
<li><b>versionName:</b> 1.0 </li>
<li><b>For API Calls:</b> Coroutines & Retrofit used </li>
<li><b>Type Of Layouts Used:</b> ConstraintLayout & SwipeRefreshLayout </li>
</ul>


<h2>Commit History</h2>
<ul>
<li><b>Last Commit:</b> ImageUtil() Created for image to base64 and insert into SharePreferences and get form offline &  Lint checkup made & styles.xml created & onItemClick written</li>
<li><b>4eed246:</b> IntentUtil modified (added new methods) & IntentUtil migrated to DI & Added comments much as I can </li>
<li><b>e269b64:</b> pika.png added (all sizes) &  BindingAdapter modified for offline situation &  Potential dataError - loading - success situation handled &  NetworkUtil created for isInternetAvailable and also for older versions supported, and also again :D Dependency Injection integrated & PreferencesUtil created for Offline storage and implemented to DI & MainActivity.kt modified and keep it simple & Constants modified for offline storage & DetailActivity.kt created</li>
<li><b>a1672ee:</b> viewBinding and dataBinding added & AppModule.kt modified & colors.xml added for Night  version & MainActivity.kt connected to lifecycle & row_user changed to Data Binding & UserAdapter. created & Bug-fix</li>
<li><b>ef7f10e:</b> AppModule modified & new dependencies | libraries added & README.md modified & UserRepository created & UsersApi created & UserViewModel created and applied dependency injection</li>
<li><b>05d145e:</b> jCenter() removed (deprecated soon) & models added & DependencyInjection used & Constants created for API things</li>
<li><b>4285b8a:</b> Initial Commit </li>
</ul>
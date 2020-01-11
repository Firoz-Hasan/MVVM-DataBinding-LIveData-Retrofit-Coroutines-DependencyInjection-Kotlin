# RetrofitKotlinExample
<b>Implementation of retrofit by using kotlin for understading </b>
<br>
<ol type="1">
<li>
In order to understand retrofit, first you have to check the API response thoroughly, there are several way response may come. For example,<br>
<ul>
<li>
  {  }  which means object<br>
</li>
<li>
  [  ] which means list <br>
  </li>
  <li>
  [ { },  { } , { },  { } , { },  { } ] which means list of objects<br>
  </li>
  <li>
[ { “data”  :  [ { }, { },  { } ]  } ] which means list of objects inside “data” object<br>
<li>
{<br>
    "page": 2,<br>
    "data": [<br>
        {<br>
            "id": 4,<br>
            "first_name": "Eve",<br>
            "last_name": "Holt",<br>
            },<br>
        {<br>
            "id": 5,<br>
            "first_name": "Charles",<br>
            "last_name": "Morris",<br>
          }
    ]
    } which means object contains list of objects 
</ul>
</li>
</li>
<Li>
  Identify the structure. Json strings will either have a Map (key-value pairs) or a List of Maps.
  Begins with curly braces? It’s a map. 
Begins with a Square bracket? That’s a List of maps.
<li>
Generally it will be either @GET or @Post HTTP request method
  <ul>
<li>
@GET : you can see both key & value in the URL
  </li>
    <li>
@Post : you cant see key or value, it will be send as body
      </li></ul>
</li>
<li>
In the @GET or @Post HTTP request method there can be different kind of parameters pass inside the method
<ul>
<li>
@Body – Sends Java objects as request body.
</li>
<li>
@PATH – https://restcountries.eu/rest/v2/capital/{cairo}
</li>
<li>
@Url – use dynamic URLs.
</li>
<li>
@Query – We can simply add a method parameter with @Query() and a query parameter name, describing the type. To URL encode a query use the form: @Query(value = "auth_token",encoded = true) String auth_token – http://jobs.bdjobs.com/apps/api/v1/joblist.asp?
</li>
<li>
@Field – send data as form-urlencoded. This requires a @FormUrlEncoded annotation attached with the method. The @Field parameter works only with a POST
</li>
</ul>
</li>
<li>
@GET(Constant.CAPITAL)
    fun getCountry(@Path("capital") capitalOfCountry: String): Call<List<Country>>
Which means when getKountry is called then it gonna return <<list of country : it should be a pojo class >> the json objects gonna serialized in the POJO/model class.
</li>
<li>
Retrofit automatically serialises the JSON response using a POJO(Plain Old Java Object) which must be defined in advanced for the JSON Structure. To serialise JSON we need a converter to convert it into Gson first. 
</li>
<li>
Gson : <ul>
<li>
Json is a FORMAT.
  </li>
<li>
We need convert our data when it comes through Api so
Object ---> Json OR Json ---> object(POJO) so thats why we need Gson.
  </li>
  </ul>
  
  /* --------------------------------HOW MVVM WORKS-----------------------------------------
   * MODEL :
   * In Android, the role of a model is usually played by a data access layer
   * such as database API or REST API.
   *
   * VIEW :
   * View is basically a passive interface cum UI which is
   * responsible for routing user’s action to the presenter.
   * In Android, View can be your Activity, fragment or RecyclerView Adapters.
   * In general, View is not visible to your Model except
   * for the POJOS and entities of your application.
   * To put in more simpler terms, Views do not communicate directly to Models.
   * However, they talk to presenters.
   *
   Business logic should be part of viewmodel
   
   
   VIEWMODEL :
   wht it does is : * it provides the data to UI. * load the data fm network or db
   SO viewmodel act as communication layer between Network/DB and UI
   data is preserved on confg changes why? activity / frag fetching data fm viewmodel so if activity
   is recreated it taking/ fetching data from same viewmodel.
   LIVEDATA :
   We used to update THI UI through interface
   reduce boiler plate code
   SO why use livedata with viewmodel?
   Viewmodel survives during configuration changes &
   livedata helps to update UI(without interface) as it can be observed
   
   LiveData is basically a data holder and it is used to observe the changes of a particular view and then update the corresponding change. What is the difference between livedata and mutablelivedata? -> LiveData is immutable while MutableLiveData is mutable
   
   
   ViewModel : holding and preparing data for the UI / ViewModel stores UI-related data that isn't destroyed on app rotations.
   SO activity / frag connects this
   viewmodel and gets all necessary data fm there and reporting user interaciton
   to viewmodel and then viewmodel forward this user interaciton to underline layout
   of the app either to load new data or to make change to dataset.
   SO viewmodel works as a gateway for the UI controller (activity/frag)
   and rest of the app.


Dependency Injection
we should not create instance of other CLASS(B) inside a CLASS(A) bec it is making CLASS(A) dependant on CLASS(B). it makes our code tightly coupled.

For example 
we have class driver and class vehicle.
class driver is dependent on class vehicle.
      
 Coroutines 
new way of writing asynchrounous code
light weight and much more eficient thread
background thread
threading in android
couritines is like jobs, couritines 1, couritines 2, couritines 3 all of them can be under One thread.
coroutines scope like group jobs / coroutines together into similar category and take action many of them at once.
coroutines suspend marks that this fun will be performed asynchrously / can execute long running operation and wait for it without blocking
suspend func is the center of everything in coroutines, it performs asynctask operation, can be paused and resuming at later time, can execute long running operation and wait for it without blocking.
coroutines scope / another suspend func
async
When you execute something synchronously, you wait for it to finish before moving on to another task. When you execute something asynchronously, you can move on to another task before it finishes.

lamda = function with no name

notification compat builder

annotation : 
An annotation is just a way to mark a class, field, another annotation, method etc. Why? It just tells that the marked component has a special attribute. But how do you handle it?
       
</ol>


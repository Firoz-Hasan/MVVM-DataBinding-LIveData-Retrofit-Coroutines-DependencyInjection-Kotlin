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
  
  /* --------------------------------HOW MVP WORKS-----------------------------------------
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
   PRESENTER :
   *  0. In MVP the presenter assumes the functionality of the "middle-man".
   * All presentation logic is pushed to the presenter.
   * 1. Listens to user action and model updates
   * 2. Updates model and view
   * 3. Presenter is the middleman or mediator between View and Model
   * which hold responsibilities of everything which has to deal
   * with presentation logic in your application.
   * In general terms, Presenter does the job of
   * querying your Model, updating the View while responding to the user’s interactions.
   * It monitors Model and talks to View so that
   * they can handle when a particular View needs to be updated and when to not.
   *
   Business logic should be part of presenter
    * Presenter: This is the brain of the app. All the business logic is kept here. It is responsible for keeping the view and model away from each other. View and Model can only talk through the Presenter. The view-model interaction can be:
       The view is requesting data from the model to show to the user.
       The model is updated in the background and now the view needs to be updated to show the latest information
       The view needs to update the model according to the user interaction.
       Presenter prides itself to handle all of this!!
</ol>


package com.example.netflixclone

import android.os.Bundle
import android.provider.CalendarContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflixclone.ui.theme.NetflixCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .background(Color.Black)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                TopAppSection()
                ContentSelection()
                FeaturedMovieSection()
                WatchAgainMovies()
                NewRelease()
                Drama()
                Action()
            }
        }
    }
}

@Composable
fun TopAppSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = R.drawable.netflix_logo),
            contentDescription = "Netflix Logo",
            modifier = Modifier.size(65.dp)

        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "Search Icon",
                modifier = Modifier
                    .size(45.dp)
                    .padding(end = 10.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.user),
                contentDescription = "User Icon",
                modifier = Modifier
                    .size(45.dp)
                    .padding(end = 6.dp, start = 6.dp)
            )
        }
    }
}

@Composable
fun ContentSelection(){
    Row(
        modifier = Modifier
            .background(Color.Black)
            .padding(horizontal = 30.dp, vertical = 20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ){
            Text(
                text = "TV Shows",
                color = Color.LightGray,
                fontSize = 18.sp,

            )


            Text(
                text = "Movies",
                color = Color.LightGray,
                fontSize = 18.sp,
            )


            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "TV Shows",
                    color = Color.LightGray,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(end = 5.dp)

                )

                Image(
                    painter = painterResource(id = R.drawable.down),
                    contentDescription = "Explore"
                )
            }
    }
}

@Composable
fun FeaturedMovieSection(){

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
           Image(
               painter = painterResource(id = R.drawable.money_heist),
               contentDescription = "",
               modifier = Modifier
                   .size(350.dp)
                   .padding(top = 30.dp),
           )


           Row(
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(vertical = 25.dp, horizontal = 50.dp),
               horizontalArrangement = Arrangement.SpaceBetween,
               verticalAlignment = Alignment.CenterVertically
           ){
               Text(
                   text = "Thriller",
                   color = Color.White
               )
               Text(
                   text = ".",
                   color = Color.White
               )
               Text(
                           text = "Action",
                   color = Color.White
               )
               Text(
                           text = ".",
                   color = Color.White
               )
               Text(
                           text = "Heist",
                   color = Color.White
               )
               Text(
                           text = ".",
                   color = Color.White
               )
               Text(
                           text = "Crime",
                   color = Color.White
               )
           }



        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 50.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(id = R.drawable.add), contentDescription = "")

                Text(
                    text = "My List",
                    color = Color.White
                )
            }


            Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.White),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text(
                    text = "Play",
                    color = Color.Black,
                    fontSize = 18.sp
                )
            }


            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(id = R.drawable.info), contentDescription = "")

                Text(
                    text = "info",
                    color = Color.White
                )
            }


        }






    }

}



@Composable
fun WatchAgainMovies(){

    val listOfMovies = mutableListOf<MovieStructure>()
    listOfMovies.add(MovieStructure(R.drawable.img1))
    listOfMovies.add(MovieStructure(R.drawable.img2))
    listOfMovies.add(MovieStructure(R.drawable.img3))
    listOfMovies.add(MovieStructure(R.drawable.img4))
    listOfMovies.add(MovieStructure(R.drawable.img5))


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
          Text(
              text = "Watch It Again",
              fontSize = 20.sp,
              color = Color.White,
              modifier = Modifier.padding(bottom = 15.dp , start = 12.dp)
          )


          LazyRow(
              modifier = Modifier.padding(horizontal = 15.dp)
          ){
              itemsIndexed(listOfMovies){index, item ->
                  MovieUi(image = item.imageRes)
              }
          }
    }
}
@Composable
fun NewRelease(){

    val listOfMovies = mutableListOf<MovieStructure>()
    listOfMovies.add(MovieStructure(R.drawable.img6))
    listOfMovies.add(MovieStructure(R.drawable.img7))
    listOfMovies.add(MovieStructure(R.drawable.img8))
    listOfMovies.add(MovieStructure(R.drawable.img9))
    listOfMovies.add(MovieStructure(R.drawable.img10))


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        Text(
            text = "New Release",
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.padding(bottom = 15.dp , start = 12.dp)
        )


        LazyRow(
            modifier = Modifier.padding(horizontal = 15.dp)
        ){
            itemsIndexed(listOfMovies){index, item ->
                MovieUi(image = item.imageRes)
            }
        }
    }
}
@Composable
fun Drama(){
    val listOfMovies = mutableListOf<MovieStructure>()
    listOfMovies.add(MovieStructure(R.drawable.image1))
    listOfMovies.add(MovieStructure(R.drawable.image2))
    listOfMovies.add(MovieStructure(R.drawable.image3))
    listOfMovies.add(MovieStructure(R.drawable.image4))
    listOfMovies.add(MovieStructure(R.drawable.image5))

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        Text(
            text = "Drama",
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.padding(bottom = 15.dp , start = 12.dp)
        )


        LazyRow(
            modifier = Modifier.padding(horizontal = 15.dp)
        ){
            itemsIndexed(listOfMovies){index, item ->
                MovieUi(image = item.imageRes)
            }
        }
    }
}
@Composable
fun Action(){
    val listOfMovies = mutableListOf<MovieStructure>()
    listOfMovies.add(MovieStructure(R.drawable.image6))
    listOfMovies.add(MovieStructure(R.drawable.image7))
    listOfMovies.add(MovieStructure(R.drawable.image8))
    listOfMovies.add(MovieStructure(R.drawable.image9))
    listOfMovies.add(MovieStructure(R.drawable.image10))

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        Text(
            text = "Action",
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.padding(bottom = 15.dp , start = 12.dp)
        )


        LazyRow(
            modifier = Modifier.padding(horizontal = 15.dp)
        ){
            itemsIndexed(listOfMovies){index, item ->
                MovieUi(image = item.imageRes)
            }
        }
    }
}



@Composable
fun MovieUi(
    image : Int
){
    Image(
        painter = painterResource(image),
        contentDescription = "",
        modifier = Modifier
            .height(130.dp)
            .width(110.dp)
            .padding(end = 10.dp)

    )
}

data class MovieStructure(
    val imageRes : Int
)
package com.example.sportfacts.data.collection

import com.example.sportfacts.R
import com.example.sportfacts.data.model.FactModel

sealed class CollectionFacts {
    object BaseballFacts {
        val listFact = listOf(
            FactModel(
                "Baseball is often referred to as \"America's pastime\" and has a rich history in the United States.\n" +
                        "\n",
                R.drawable.baseball_fact
            ),
            FactModel(
                "The sport's origins can be traced back to the 18th century," +
                        " with a form of baseball being played in the United States as early as the 1790s.",
                R.drawable.baseball_fact
            ),
            FactModel("The first recorded baseball game in history" +
                    " took place on June 19, 1846, in Hoboken, New Jersey.",
                R.drawable.baseball_fact
            ),
            FactModel(
                "The baseball diamond, also known as the infield, has bases 90 feet apart," +
                        " and the pitcher's mound is 60 feet, 6 inches from home plate.",
                R.drawable.baseball_fact
            ),
            FactModel(
                "Babe Ruth, often called \"The Sultan of Swat,\" is one of the most famous " +
                        "baseball players of all time and held numerous records," +
                        " including the most home runs in a season.",
                R.drawable.baseball_fact
            )
        )
    }

    object FootballFacts {
        val listFact = listOf(
            FactModel(
                "Football, also known as soccer in some countries, has its origins in England." +
                        " The modern version of the game was developed there in the 19th century.",
                R.drawable.football_fact
            ),
            FactModel(
                "The FIFA World Cup is the most-watched sporting event in the world." +
                        " It takes place every four years and attracts billions of viewers.",
                R.drawable.football_fact
            ),
            FactModel(
                "Brazilian legend Pelé is the only player to have won three FIFA World Cups " +
                        "in 1958, 1962, and 1970.",
                R.drawable.football_fact
            ),
            FactModel(
                "Hakan Şükür of Turkey holds the record for the fastest goal in a World Cup," +
                        " scoring just 11 seconds into a match against South Korea in 2002.",
                R.drawable.football_fact
            ),
            FactModel("Lionel Messi scored a record 91 goals in 2012," +
                    " surpassing Gerd Müller's previous record.",
                R.drawable.football_fact
            )
        )
    }

    object BasketBallFacts {
        val listFact = listOf(
            FactModel(
                "Basketball was invented by Dr. James Naismith in December 1891 in Springfield," +
                        " Massachusetts, USA.",
                R.drawable.basketball_fact
            ),
            FactModel("The first basketball game was played with " +
                    "a soccer ball and two peach baskets as goals.",
                R.drawable.basketball_fact
            ),
            FactModel(
                "The National Basketball Association (NBA) is the" +
                        " premier men's professional basketball league in the world.",
                R.drawable.basketball_fact
            ),
            FactModel(
                "The shortest player in NBA history is Tyrone \"Muggsy\" Bogues," +
                        " who stands at 5 feet 3 inches (160 cm) tall.",
                R.drawable.basketball_fact
            ),
            FactModel("The Chicago Bulls, led by Michael Jordan," +
                    " won six NBA championships in the 1990s.",
                R.drawable.basketball_fact
            )
        )
    }

    object ChessFacts {
        val listFact = listOf(
            FactModel("Chess is believed to have originated in India" +
                    " during the Gupta Empire in the 6th century.",
                R.drawable.chess_fact
            ),
            FactModel("The knight in chess is the only piece that" +
                    " can \"jump\" over other pieces on the board.",
                R.drawable.chess_fact
            ),
            FactModel(
                "The longest chess game ever played lasted for 269 moves" +
                        " and ended in a draw due to the fifty-move rule.",
                R.drawable.chess_fact
            ),
            FactModel(
                "The current world chess champion is Magnus Carlsen from Norway," +
                        " who has held the title since 2013.",
                R.drawable.chess_fact
            ),
            FactModel(
                "The first official World Chess Championship was held in 1886," +
                        " with Wilhelm Steinitz becoming the first champion.",
                R.drawable.chess_fact
            )
        )
    }
}

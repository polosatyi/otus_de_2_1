package com.example


case class Wine(
                 id: Option[Int],
                 country: Option[String],
                 points: Option[Int],
                 price: Option[Int],
                 title: Option[String],
                 variety: Option[String],
                 winery: Option[String]
               )

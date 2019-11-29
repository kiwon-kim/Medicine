package com.example.medicine.repositories

class Sqlwhere {

    var whereType = ""
    var whereShape = ""
    var whereColor = ""
    var whereMarker = ""


    fun notAllInput(marker: String?, type: String?, shape: String?, color: String? ): String {
        if(type != "") whereType = "a.제형 like '%$type%'" else whereType = "a.제형 like '%%'"
        if(shape != "") whereShape = "and a.모양 like '%$shape%'"
        if(color != "") whereColor = "and a.색상 like '%$color%'"
        if(marker != "") whereMarker = "and a.식별 like '%$marker%'"
//    where  a.제형 like '%정제%' or a.색상 like '%분홍%' or a.모양 like '%타원%' or a.식별 like '%정제%';
        val sqlWhere = whereType + whereShape + whereColor + whereMarker
        println(sqlWhere)
        return sqlWhere
    }

}
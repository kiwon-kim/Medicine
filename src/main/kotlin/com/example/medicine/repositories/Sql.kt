package com.example.medicine.repositories

class Sql {
    var sql = "select * from (" +
            "\tselect p.name 약이름, m.name 제약회사, s.name 모양, t.name 제형, p.marker 식별, c.name 색상, p.ingredient, p.effect, p.usage, p.caution \n" +
            "\tfrom Medicine p, Maker m , Shape s, Type t, Color c \n" +
            "\twhere p.makerId = m.makerId and p.shapeId = s.shapeId and p.typeId = t.typeId and p.colorId = c.colorId \n" +
            ") a\n" +
            " where  a.약이름 like ? and a.식별 like ? and a.제형 like ? and a.모양 like ? and a.색상 like ?;"
}
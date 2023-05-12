package com.gildedrose
abstract class Item(var name: String, var sellIn: Int, var quality: Int) {
    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }
}

class Sulfuras (
    sellIn: Int,
) : Item("Sulfuras, Hand of Ragnaros", sellIn, 80)

class AgedBrie (
    sellIn: Int,
    quality: Int
) : Item("Aged Brie", sellIn, quality) {
    init {
        require(quality in 0..50) {
            "quality should be between 0..50"
        }
    }
}

class BackstagePasses(
    sellIn: Int,
    quality: Int
) : Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) {
    init {
        require(quality in 0..50) {
            "quality should be between 0..50"
        }
    }
}

class NormalItem(
    name: String,
    sellIn: Int,
    quality: Int
) : Item(name, sellIn, quality) {
    init {
        require(quality in 0..50) {
            "quality should be between 0..50"
        }
    }
}

class ConjuredItem(sellIn: Int, quality: Int): Item("Conjured Mana Cake", sellIn, quality) {
    init {
        require(quality in 0..50) {
            "quality should be between 0..50"
        }
    }
}

package com.gildedrose

class GildedRose(val items: List<Item>) {

    fun updateItems() {
        for (item in items) {
            when (item) {
                is AgedBrie -> updateAgedBrie(item)
                is BackstagePasses -> updateBackstagePasses(item)
                is ConjuredItem-> updateConjuredItem(item)
                is Sulfuras -> continue
                else -> updateNormalItem(item)
            }
        }
    }

    private fun updateAgedBrie(item: Item) {
        decreaseSellIn(item)
        increaseQuality(item)
        if (item.sellIn < 0) {
            increaseQuality(item)
        }
    }

    private fun updateBackstagePasses(item: Item) {
        decreaseSellIn(item)
        increaseQuality(item)
        if (item.sellIn < 11) {
            increaseQuality(item)
        }
        if (item.sellIn < 6) {
            increaseQuality(item)
        }
        if (item.sellIn < 0) {
            item.quality = 0
        }
    }

    private fun updateNormalItem(item: Item) {
        decreaseSellIn(item)
        decreaseQuality(item)
        if (item.sellIn < 0) {
            decreaseQuality(item)
        }
    }

    private fun updateConjuredItem(item: Item) {
        decreaseSellIn(item)
        repeat(2) { decreaseQuality(item) }
        if (item.sellIn < 0) {
            repeat(2) { decreaseQuality(item) }
        }
    }

    private fun increaseQuality(item: Item) {
        if (item.quality < 50) {
            item.quality++
        }
    }

    private fun decreaseQuality(item: Item) {
        if (item.quality > 0) {
            item.quality--
        }
    }

    private fun decreaseSellIn(item: Item) {
        item.sellIn--
    }

}
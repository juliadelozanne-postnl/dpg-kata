package com.gildedrose

class GildedRose(val items: List<Item>) {

    fun updateItems() {
        for (item in items) {
            when (item) {
                is AgedBrie -> updateAgedBrie(item)
                is BackstagePasses -> updateBackstagePasses(item)
                is ConjuredItem -> updateConjuredItem(item)
                is Sulfuras -> continue
                else -> updateNormalItem(item)
            }
        }
    }

    private fun updateAgedBrie(item: Item) {
        decreaseSellIn(item).also {
            when {
                item.sellIn < 0 -> repeat(2) { increaseQuality(item) }
                else -> increaseQuality(item)
            }
        }
    }

    private fun updateBackstagePasses(item: Item) {
        decreaseSellIn(item).also {
            when {
                item.sellIn < 0 -> item.quality = 0
                item.sellIn in 0..5 -> repeat(3) { increaseQuality(item) }
                item.sellIn in 6..11 -> repeat(2) { increaseQuality(item) }
                else -> increaseQuality(item)
            }
        }
    }

    private fun updateNormalItem(item: Item) {
        decreaseSellIn(item).also {
            when {
                item.sellIn < 0 -> repeat(2) { decreaseQuality(item) }
                else -> decreaseQuality(item)
            }
        }
    }

    private fun updateConjuredItem(item: Item) {
        decreaseSellIn(item).also {
            when {
                item.sellIn < 0 -> repeat(4) { decreaseQuality(item) }
                else -> repeat(2) { decreaseQuality(item) }
            }
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
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
        with(item) {
            decreaseSellIn(this).also {
                when {
                    sellIn < 0 -> repeat(2) { increaseQuality(this) }
                    else -> increaseQuality(this)
                }
            }
        }
    }

    private fun updateBackstagePasses(item: Item) {
        with(item) {
            decreaseSellIn(this).also {
                when {
                    sellIn < 0 -> quality = 0
                    sellIn in 0..5 -> repeat(3) { increaseQuality(this) }
                    sellIn in 6..11 -> repeat(2) { increaseQuality(this) }
                    else -> increaseQuality(this)
                }
            }
        }
    }

    private fun updateNormalItem(item: Item) {
        with(item) {
            decreaseSellIn(this).also {
                when {
                    sellIn < 0 -> repeat(2) { decreaseQuality(this) }
                    else -> decreaseQuality(this)
                }
            }
        }
    }

    private fun updateConjuredItem(item: Item) {
        with(item) {
            decreaseSellIn(this).also {
                when {
                    sellIn < 0 -> repeat(4) { decreaseQuality(this) }
                    else -> repeat(2) { decreaseQuality(this) }
                }
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
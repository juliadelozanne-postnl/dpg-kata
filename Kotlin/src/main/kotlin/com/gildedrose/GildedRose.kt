package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            if (items[i].name != "Aged Brie" && items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                if (items[i].quality > 0) {
                    if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                        items[i].quality = items[i].quality - 1
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1

                    if (items[i].name == "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1
                            }
                        }
                    }
                }
            }

            if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                items[i].sellIn = items[i].sellIn - 1
            }

            if (items[i].sellIn < 0) {
                if (items[i].name != "Aged Brie") {
                    if (items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].quality > 0) {
                            if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                                items[i].quality = items[i].quality - 1
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1
                    }
                }
            }
        }
    }

    fun updateItems() {
        for (item in items) {
            when (item.name) {
                "Aged Brie" -> updateAgedBrie(item)
                "Backstage passes to a TAFKAL80ETC concert" -> updateBackstagePasses(item)
                "Conjured Mana Cake" -> updateConjuredItem(item)
                "Sulfuras, Hand of Ragnaros" -> continue
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
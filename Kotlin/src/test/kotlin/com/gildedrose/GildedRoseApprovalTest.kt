package com.gildedrose

import org.approvaltests.combinations.CombinationApprovals
import org.junit.jupiter.api.Test

internal class GildedRoseApprovalTest {

    @Test
    fun `combination approval tests for aged brie items`() {
        fun updateQualityItem(sellIn: Int, quality: Int): String {
            val items = listOf(AgedBrie(sellIn, quality))
            val app = GildedRose(items)
            app.updateItems()
            return items[0].toString()
        }

        val sellIns = arrayOf(0, 6, 11, 12)
        val qualities = arrayOf(0, 10, 49, 50)

        CombinationApprovals.verifyAllCombinations(::updateQualityItem, sellIns, qualities)
    }

    @Test
    fun `combination approval tests for conjured items`() {
        fun updateQualityItem(sellIn: Int, quality: Int): String {
            val items = listOf(ConjuredItem(sellIn, quality))
            val app = GildedRose(items)
            app.updateItems()
            return items[0].toString()
        }

        val sellIns = arrayOf(0, 6, 11, 12)
        val qualities = arrayOf(0, 10, 49, 50)

        CombinationApprovals.verifyAllCombinations(::updateQualityItem, sellIns, qualities)
    }

    /*@Test
    fun `update quality approval test`() {
        fun updateQualityItem(name: String, sellIn: Int, quality: Int): String {
            val items = listOf(Item(name, sellIn, quality))
            val app = GildedRose(items)
            app.updateQuality()
            return items[0].toString()
        }

        val sellIns = arrayOf(0, 6, 11, 12)
        val qualities = arrayOf(0, 10, 49, 50)
        val names = arrayOf(
            "Sulfuras, Hand of Ragnaros",
            "Aged Brie",
            "Backstage passes to a TAFKAL80ETC concert",
            "+5 Dexterity Vest",
            "Elixir of the Mongoose"
        )

        CombinationApprovals.verifyAllCombinations(::updateQualityItem, names, sellIns, qualities)
    }*/
}

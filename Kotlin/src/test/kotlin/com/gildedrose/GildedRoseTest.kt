package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun `should decrease quality by two when Conjured Mana Cake is updated`() {
        val items = listOf(ConjuredItem( 5, 10))
        val app = GildedRose(items)
        app.updateItems()
        assertEquals("Conjured Mana Cake", app.items[0].name)
        assertEquals(8, app.items[0].quality)
        assertEquals(4, app.items[0].sellIn)
    }

    @Test
    fun `should decrease quality by four when Conjured Mana Cake is updated after sell date`() {
        val items = listOf(ConjuredItem( 0, 10))
        val app = GildedRose(items)
        app.updateItems()
        assertEquals("Conjured Mana Cake", app.items[0].name)
        assertEquals(6, app.items[0].quality)
        assertEquals(-1, app.items[0].sellIn)
    }

    /*
    This is how I started. This code is only still here because of the interview and to explain my approach
    @Test
    fun `should decrease quality by two when Conjured Mana Cake is updated before sell date`() {
        val items = listOf(Item("Conjured Mana Cake", 2, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Conjured Mana Cake", app.items[0].name)
        assertEquals(8, app.items[0].quality)
        assertEquals(1, app.items[0].sellIn)
    }

    @Test
    fun `should not change quality or sell date when Sulfuras, Hand of Ragnaros is updated`() {
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", 0, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name)
        assertEquals(80, app.items[0].quality)
        assertEquals(0, app.items[0].sellIn)
    }

    @Test
    fun `should increase quality by one when Aged Brie is updated`() {
        val items = listOf(Item("Aged Brie", 2, 40))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Aged Brie", app.items[0].name)
        assertEquals(41, app.items[0].quality)
        assertEquals(1, app.items[0].sellIn)
    }

    @Test
    fun `should increase quality by two when Aged Brie is updated after sell date`() {
        val items = listOf(Item("Aged Brie", 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Aged Brie", app.items[0].name)
        assertEquals(12, app.items[0].quality)
        assertEquals(-1, app.items[0].sellIn)
    }

    @Test
    fun `should decrease quality by one when Backstage passes to a TAFKAL80ETC concert is updated`() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 0, 40))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name)
        assertEquals(0, app.items[0].quality)
        assertEquals(-1, app.items[0].sellIn)
    }

    @Test
    fun `should drop quality to 0 for Backstage passes to a TAFKAL80ETC concert after sell date`() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name)
        assertEquals(0, app.items[0].quality)
        assertEquals(-1, app.items[0].sellIn)
    }

    @Test
    fun `should decrease quality by one for +5 Dexterity Vest`() {
        val items = listOf(Item("+5 Dexterity Vest", 10, 40))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("+5 Dexterity Vest", app.items[0].name)
        assertEquals(39, app.items[0].quality)
        assertEquals(9, app.items[0].sellIn)
    }

    @Test
    fun `should decrease quality by two for +5 Dexterity Vest after sell date`() {
        val items = listOf(Item("+5 Dexterity Vest", 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("+5 Dexterity Vest", app.items[0].name)
        assertEquals(8, app.items[0].quality)
        assertEquals(-1, app.items[0].sellIn)
    }

    @Test
    fun `should decrease quality by one for Elixir of the Mongoose`() {
        val items = listOf(Item("Elixir of the Mongoose", 2, 40))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Elixir of the Mongoose", app.items[0].name)
        assertEquals(39, app.items[0].quality)
        assertEquals(1, app.items[0].sellIn)
    }

    @Test
    fun `should decrease quality by two for Elixir of the Mongoose after sell date`() {
        val items = listOf(Item("Elixir of the Mongoose", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Elixir of the Mongoose", app.items[0].name)
        assertEquals(0, app.items[0].quality)
        assertEquals(-1, app.items[0].sellIn)
    }

    @Test
    fun `should never drop quality below 0 all items except Sulfuras`() {
        val items = listOf(Item("Elixir of the Mongoose", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Elixir of the Mongoose", app.items[0].name)
        assertEquals(0, app.items[0].quality)
        assertEquals(-1, app.items[0].sellIn)
    }

    @Test
    fun `should never increase quality above 50 for all items except Sulfuras`() {
        val items = listOf(Item("Elixir of the Mongoose", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Elixir of the Mongoose", app.items[0].name)
        assertEquals(0, app.items[0].quality)
        assertEquals(-1, app.items[0].sellIn)
    }*/
}
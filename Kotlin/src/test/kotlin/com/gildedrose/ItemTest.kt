package com.gildedrose

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ItemTest {

    @Test
    fun `should instantiate sulfuras class`() {
        val item = Sulfuras(2)
        assertEquals("Sulfuras, Hand of Ragnaros", item.name)
        assertEquals(80, item.quality)
        assertEquals(2, item.sellIn)
    }

    @Test
    fun `should instantiate backstage passes class`() {
        val item = BackstagePasses(2, 10)
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name)
        assertEquals(10, item.quality)
        assertEquals(2, item.sellIn)
    }

    @Test
    fun `should instantiate aged brie class`() {
        val item = AgedBrie(2, 10)
        assertEquals("Aged Brie", item.name)
        assertEquals(10, item.quality)
        assertEquals(2, item.sellIn)
    }

    @Test
    fun `should instantiate ordinary item class`() {
        val item = NormalItem("Mongoose", 2, 10)
        assertEquals("Mongoose", item.name)
        assertEquals(10, item.quality)
        assertEquals(2, item.sellIn)
    }

    @Test
    fun `should throw exception quality too high for backstage passes class`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            BackstagePasses(2, 51)
        }
        assertEquals("quality should be between 0..50", exception.message)
    }

    @Test
    fun `should throw exception quality too high for aged brie class`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            AgedBrie(2, 51)
        }
        assertEquals("quality should be between 0..50", exception.message)
    }

    @Test
    fun `should throw exception quality too high for ordinary item class`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            NormalItem("Mongoose", 2, 51)
        }
        assertEquals("quality should be between 0..50", exception.message)
    }

    @Test
    fun `should throw exception quality too low for backstage passes class`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            BackstagePasses(2, -1)
        }
        assertEquals("quality should be between 0..50", exception.message)
    }

    @Test
    fun `should throw exception quality too low for aged brie class`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            AgedBrie(2, -1)
        }
        assertEquals("quality should be between 0..50", exception.message)
    }

    @Test
    fun `should throw exception quality too low for ordinary item class`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            NormalItem("Mongoose", 2, -1)
        }
        assertEquals("quality should be between 0..50", exception.message)
    }
}
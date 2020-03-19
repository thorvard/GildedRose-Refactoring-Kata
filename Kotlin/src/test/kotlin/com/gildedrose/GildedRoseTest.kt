package com.gildedrose

import org.junit.Assert.assertEquals
import org.junit.Test

class GildedRoseTest {

    @Test
    fun `should not change item name when quality updated`() {
        val items = arrayOf<Item>(Item("foo", 0, 0))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals("foo", app.items[0].name)
    }

    @Test
    fun `should not change empty item name when quality updated`() {
        val items = arrayOf<Item>(Item("", 0, 0))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals("", app.items[0].name)
    }

    @Test
    fun `should not change multi-part item name when quality updated`() {
        val items = arrayOf<Item>(Item("foo bar", 0, 0))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals("foo bar", app.items[0].name)
    }

    @Test
    fun `should decrease item sellIn by 1 when quality updated`() {
        val items = arrayOf<Item>(Item("foo", 5, 0))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(4, app.items[0].sellIn)
    }

    @Test
    fun `should not change item sellIn when item name is Sulfuras, Hand of Ragnaros and quality updated`() {
        val items = arrayOf<Item>(Item("Sulfuras, Hand of Ragnaros", 5, 0))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(5, app.items[0].sellIn)
    }
}



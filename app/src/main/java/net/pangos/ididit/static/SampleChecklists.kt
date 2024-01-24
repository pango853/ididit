@file:JvmName("SampleChecklists")
package net.pangos.ididit.static

class SampleChecklists {
    companion object Sample { // equivalent to static methods of Java

        // This annotation tells Java classes to treat this method as if it was a static to [KotlinClass]
        @JvmStatic
        fun create(): SampleChecklists = SampleChecklists()

        //Without it, you would have to use [KotlinClass.Companion.bar()] to use this method.
        fun a(): Int = 1
    }
}
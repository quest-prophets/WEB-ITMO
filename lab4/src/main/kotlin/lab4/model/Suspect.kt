package lab4.model

data class Suspect(var area1: Int, var area2: Int, var area3: Int, var area4: Int) {
    companion object {
        fun decode(saved: Int): Suspect = Suspect(saved and 255,
            (saved shr 8) and 255,
            (saved shr 16) and 255,
            (saved shr 24) and 255)
    }
    fun encode(): Int = (this.area4 shl 24) or (this.area3 shl 16) or (this.area2 shl 8) or this.area1
}
import java.io.File

private const val WEBM_PATH = """C:\Users\takusan23\Downloads\record-1703001154715.webm"""
private val DOWNLOAD_FOLDER = File(System.getProperty("user.home"), "Downloads")

fun main(args: Array<String>) {
    // ファイルを読み出す
    val webmByteArray = File(WEBM_PATH).readBytes()
    // 要素のリストに
    val elementList = FixWebmSeek.parseWebm(webmByteArray)
    // シークできる WebM にする
    val seekableWebmByteArray = FixWebmSeek.fixSeekableWebM(elementList)
    File(DOWNLOAD_FOLDER, "fix_webm_seek_kotlin_${System.currentTimeMillis()}.webm").writeBytes(seekableWebmByteArray)
}
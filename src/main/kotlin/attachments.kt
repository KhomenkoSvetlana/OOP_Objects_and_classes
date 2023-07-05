
interface Attachments {
    val type : String
}

data class AttachmentsPhoto (val photo: Photo): Attachments {
    override val type: String = "photo"
}
class Photo(
        val id: Int,
        val ownerId: Int, //Идентификатор владельца фотографии
        val photo130: String, //URL изображения для предпросмотра
        val photo604: String // URL полноразмерного изображения
)

data class AttachmentsVideo (val video: Video) : Attachments {
    override val type: String = "video"
}
class Video (
        val id: Int,
        val ownerId: Int,
        val artist: String,
        val description: String,
        val views: Int
)

data class AttachmentsAudio (val audio: Audio) : Attachments {
    override val type: String = "audio"
}
class Audio (
        val id: Int,
        val ownerId: Int,
        val artist: String,
        val title: String,
        val url: String,
)

data class AttachmentsDoc (val doc: Doc) : Attachments {
    override val type: String = "doc"
}
class Doc(
        val id: Int, //Идентификатор файла
        val ownerId: Int, //Идентификатор пользователя, загрузившего файл
        val title: String, // Название файла
        val url: String
)

data class AttachmentsLink (val link: Link) : Attachments {
    override val type: String = "link"
}

class Link(
    val url : String,
    val title: String,
    val description: String //Описание ссылки
)




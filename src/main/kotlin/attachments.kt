<<<<<<< HEAD
=======

>>>>>>> d1ceaaca1eee8493581c2fa64030d184ce16bfc0
interface Attachments {
    val type : String
}

<<<<<<< HEAD
data class AttachmentsPhoto (val photo: Photo): Attachments {
    override val type: String = "photo"
}

data class AttachmentsVideo (val video: Video) : Attachments {
    override val type: String = "video"
}

data class AttachmentsAudio (val audio: Audio) : Attachments {
    override val type: String = "audio"
}

data class AttachmentsDoc (val doc: Doc) : Attachments {
    override val type: String = "doc"
}

data class AttachmentsLink (val link: Link) : Attachments {
    override val type: String = "link"
=======
/*class AttachmentsPhoto () : Attachments {
    override val type: Photo

}

class AttachmentsVideo () : Attachments {
    override val type: Video

}

class AttachmentsAudio () : Attachments {
    override val type: Audio

}

class AttachmentsDoc () : Attachments {
    override val type: Doc

}

class AttachmentsLink () : Attachments {
    override val type: Link

>>>>>>> d1ceaaca1eee8493581c2fa64030d184ce16bfc0
}


class Photo(
    val id: Int,
    val ownerId: Int, //Идентификатор владельца фотографии
    val photo130: String, //URL изображения для предпросмотра
    val photo604: String // URL полноразмерного изображения
)

class Video (
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val description: String,
    val views: Int
)
class Audio (
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val url: String,
)
class Doc (
    val id: Int, //Идентификатор файла
    val ownerId: Int, //Идентификатор пользователя, загрузившего файл
    val title: String, // Название файла
    val url: String
)
class Link(
    val url : String,
    val title: String,
    val description: String //Описание ссылки
<<<<<<< HEAD
)
=======
)*/
>>>>>>> d1ceaaca1eee8493581c2fa64030d184ce16bfc0


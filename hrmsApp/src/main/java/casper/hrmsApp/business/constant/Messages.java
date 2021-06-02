package casper.hrmsApp.business.constant;

public class Messages {

    //user
    public static String userListed = "Kullanıcılar listelendi.";
    public static String userAdded = "Kullanıcı eklendi.";
    public static String userDeleted = "Kullanıcı silindi.";
    public static String userUpdated = "Kullanıcı güncellendi.";

    //general
    public static String notNull = "Alanlar boş bırakılamaz";
    public static String emailExist = "Bu email zaten mevcut";
    public static String PasswordNotConfirmed = "Parolalar uyuşmuyor";

    //candidate
    public static String personInValid = "Kişi doğrulaması başarısız....";
    public static String nationalityIdentityExist = "Bu kimlik numarasız zaten mevcut";
    public static String nationalIdentityInvalid = "Kimlik numarası 11 haneli olmalı";

    //jobposition
    public static String jobTitleExist = "Bu iş bölümü zaten mevcut";
    public static String jobPositionAdded = "İş bölümü eklendi";
    public static String jobPositionListed = "İş bölümleri listelendi";

    //activationCode
    public static String activationCodeAdded = "Aktivasyon kodu eklendi.";
    public static String activationCodeDeleted = "Aktivasyon kodu silindi.";
    public static String activationCodeUpdated = "Aktivasyon kodu güncellendi.";
    public static String activationCodeListed = "Aktivasyon kodları listelendi.";
    public static String codeNotFound = "Aktivasyon kodu bulunamadı";
    public static String activationExist = "Bu email zaten doğrulanmış";
    public static String codeExpired = "Aktivasyon kodunun zamanı geçmiş, bir zahmet yenisini iste";
    public static String codeNotEqual = "Aktivasyon kodu geçersiz";
    public static String codeVerified = "Aktivasyon kod doğrulaması başarılı";

    //employee
    public static String EmployeeAdded = "Sistem çalışanı eklendi";

    //jobpost
    public static String JobPostAdded = "İş ilanı eklendi";
    public static String JobPostUpdated = "İlan Güncellendi";

    public static String EducationListed = "Eğitim bilgisi listelendi";
}

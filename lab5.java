import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Абстрактный класс Hash с методом getHash
abstract class Hash {
    public abstract String getHash(String data);

    // public abstract String digestJavaHexString(String algorithm, String message);
}

// Класс для хеширования данных с использованием MD5
class MD5Hash extends Hash {

    @Override
    public String getHash(String data) {
        return "MD5 : " + digestJavaHexString("MD5", data) + "\n";
    }

    private String digestJavaHexString(String algorithm, String message) {
        StringBuffer sb = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(message.getBytes());
            byte[] digest = md.digest();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}

// Класс для хеширования данных с использованием SHA-256
class SHA256Hash extends Hash {
    @Override
    public String getHash(String data) {
        return "SHA-256 : " + digestJavaHexString("SHA-256", data) + "\n";
    }

    private String digestJavaHexString(String algorithm, String message) {
        StringBuffer sb = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(message.getBytes());
            byte[] digest = md.digest();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}

// Класс для хеширования данных с использованием SHA-1
class SHA1Hash extends Hash {
    @Override
    public String getHash(String data) {
        return "SHA-1 : " + digestJavaHexString("SHA-1", data) + "\n";
    }

    private String digestJavaHexString(String algorithm, String message) {
        StringBuffer sb = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(message.getBytes());
            byte[] digest = md.digest();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}

// Класс для хеширования данных с использованием SHA-512
class SHA512Hash extends Hash {
    @Override
    public String getHash(String data) {
        return "SHA-512 : " + digestJavaHexString("SHA-512", data) + "\n";
    }

    private String digestJavaHexString(String algorithm, String message) {
        StringBuffer sb = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(message.getBytes());
            byte[] digest = md.digest();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}

// Класс, использующий шаблонный метод и стратегию для получения хешей
class HashGenerator {
    public String getHash(String data, Hash hash) {
        System.out.println(hash);
        return hash.getHash(data);
    }
}

class Main {

    public static void main(String[] args) {
        String data = "Hello";
        System.out.println("text:   " + data + "\n");
        HashGenerator generator = new HashGenerator();

        // Использование MD5 для хеширования
        Hash md5Hash = new MD5Hash();
        String md5Result = generator.getHash(data, md5Hash);
        System.out.println(md5Result);
        // Использование SHA-256 для хеширования
        Hash sha256Hash = new SHA256Hash();
        String sha256Result = generator.getHash(data, sha256Hash);
        System.out.println(sha256Result);
        // Использование SHA-1 для хеширования
        Hash sha1Hash = new SHA1Hash();
        String sha1Result = generator.getHash(data, sha1Hash);
        System.out.println(sha1Result);
        // Использование SHA-512 для хеширования
        Hash sha512Hash = new SHA512Hash();
        String sha512Result = generator.getHash(data, sha512Hash);
        System.out.println(sha512Result);

    }

}

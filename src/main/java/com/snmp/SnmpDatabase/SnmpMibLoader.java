import java.io.File;

public class SnmpMibLoader {
    public static void main(String[] args) {
        File mibFile = new File("C://Users//antho//Downloads//GATESAIR-EVENTLOG-MIB (5)");
        // Cria um objeto 'File' que representa o caminho do arquivo MIB

        if (mibFile.exists()) {  // Verifica se o arquivo especificado existe no caminho dado.
            System.out.println("MIB encontrada: " + mibFile.getAbsolutePath());  // Se o arquivo existi mostra uma mensagem com o caminho absoluto do arquivo
        } else {  // Caso o arquivo não exista...
            System.out.println("Arquivo MIB não encontrado!");  // Mostra uma mensagem falando que o arquivo não foi encontrado.
        }
    }
}


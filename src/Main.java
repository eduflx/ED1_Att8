public class Main {

    public static void main(String[] args) {

        PlaylistTAD playlist = new PlaylistArray(10);

        System.out.println("Inserindo músicas...");

        playlist.inserirFim(101);
        playlist.inserirFim(102);
        playlist.inserirFim(103);

        playlist.exibir();

        System.out.println("\nInserindo no início...");
        playlist.inserirInicio(100);

        playlist.exibir();

        System.out.println("\nInserindo posição 2...");
        playlist.inserirPosicao(999, 2);

        playlist.exibir();

        System.out.println("\nRemovendo início...");
        playlist.removerInicio();

        playlist.exibir();

        System.out.println("\nRemovendo por ID (102)...");
        playlist.removerPorId(102);

        playlist.exibir();

        System.out.println("\nBuscando ID 999...");
        int pos = playlist.buscarPorId(999);

        System.out.println("Encontrado na posição: " + pos);

        System.out.println("\nTamanho atual: " + playlist.tamanho());

    }
}
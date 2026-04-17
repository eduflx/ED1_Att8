public class PlaylistArray implements PlaylistTAD {

    private int[] playlist;
    private int tamanho;
    private int capacidade;

    public PlaylistArray(int capacidade) {
        this.capacidade = capacidade;
        this.playlist = new int[capacidade];
        this.tamanho = 0;
    }

    // Inserir no final
    @Override
    public boolean inserirFim(int idMusica) {

        if (estaCheia())
            return false;

        playlist[tamanho] = idMusica;
        tamanho++;

        return true;
    }

    // Inserir no início (shift para direita)
    @Override
    public boolean inserirInicio(int idMusica) {

        if (estaCheia())
            return false;

        for (int i = tamanho; i > 0; i--) {
            playlist[i] = playlist[i - 1];
        }

        playlist[0] = idMusica;
        tamanho++;

        return true;
    }

    // Inserir em posição específica
    @Override
    public boolean inserirPosicao(int idMusica, int posicao) {

        if (estaCheia() || posicao < 0 || posicao > tamanho)
            return false;

        for (int i = tamanho; i > posicao; i--) {
            playlist[i] = playlist[i - 1];
        }

        playlist[posicao] = idMusica;
        tamanho++;

        return true;
    }

    // Remover do final
    @Override
    public boolean removerFim() {

        if (estaVazia())
            return false;

        tamanho--;
        return true;
    }

    // Remover do início (shift esquerda)
    @Override
    public boolean removerInicio() {

        if (estaVazia())
            return false;

        for (int i = 0; i < tamanho - 1; i++) {
            playlist[i] = playlist[i + 1];
        }

        tamanho--;

        return true;
    }

    // Remover posição
    @Override
    public boolean removerPosicao(int posicao) {

        if (estaVazia() || posicao < 0 || posicao >= tamanho)
            return false;

        for (int i = posicao; i < tamanho - 1; i++) {
            playlist[i] = playlist[i + 1];
        }

        tamanho--;

        return true;
    }

    // Remover por ID
    @Override
    public boolean removerPorId(int idMusica) {

        int pos = buscarPorId(idMusica);

        if (pos == -1)
            return false;

        return removerPosicao(pos);
    }

    // Buscar ID
    @Override
    public int buscarPorId(int idMusica) {

        for (int i = 0; i < tamanho; i++) {

            if (playlist[i] == idMusica)
                return i;
        }

        return -1;
    }

    // Obter posição
    @Override
    public int obter(int posicao) {

        if (posicao < 0 || posicao >= tamanho)
            return -1;

        return playlist[posicao];
    }

    // Verificar vazia
    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    // Verificar cheia
    @Override
    public boolean estaCheia() {
        return tamanho == capacidade;
    }

    // Retornar tamanho
    @Override
    public int tamanho() {
        return tamanho;
    }

    // Exibir playlist
    @Override
    public void exibir() {

        if (estaVazia()) {
            System.out.println("Playlist vazia");
            return;
        }

        System.out.print("Playlist: ");

        for (int i = 0; i < tamanho; i++) {
            System.out.print(playlist[i] + " ");
        }

        System.out.println();
    }
}
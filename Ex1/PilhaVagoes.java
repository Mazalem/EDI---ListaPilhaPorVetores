public class PilhaVagoes {
    int tamanho;
    int topo = -1;
    int[] pilha;

    public PilhaVagoes(int tamanho) {
        this.tamanho = tamanho;
        pilha = new int[this.tamanho];
    }

    public void push(int num) throws Exception {
        if(this.topo == tamanho - 1) {
            throw new Exception("Pilha Cheia!");
        }
        this.pilha[++topo] = num;
    }

    public int pop() throws Exception {
        if(this.topo == -1) {
            throw new Exception("Pilha Cheia!");
        }
        return this.pilha[topo--];
    }

    public void preenchePilha() {
        for (int i = this.pilha.length; i > 0; i--) {
            try {
                this.push(i);
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    public boolean isVazia() {
        return topo == -1;
    }

}

public class Pilha {
    int tamanho = 1000;
    int topo = -1;
    char[] pilha;

    public Pilha() {
        pilha = new char[this.tamanho];
    }

    public void push(char caractere) throws Exception {
        if(this.topo == this.tamanho - 1) {
            throw new Exception("Pilha Cheia!");
        }
        this.pilha[++topo] = caractere;
    }

    public char pop() throws Exception {
        if(this.topo == -1) {
            throw new Exception("Pilha Cheia!");
        }
        return this.pilha[topo--];
    }

    public boolean isVazia() {
        return topo == -1;
    }

}

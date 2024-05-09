from flask import Flask, render_template, redirect, request

app = Flask(__name__)

# Lista de usuários (simulando um banco de dados)
usuarios = []

# Contador para atribuir IDs únicos aos usuários
contador_id = 1

# Página inicial
@app.route("/")
def index():
    return render_template("index.html", usuarios=usuarios)

# Adicionar usuário
@app.route("/adicionar", methods=["POST"])
def adicionar():
    global contador_id
    nome = request.form.get("nome")
    email = request.form.get("email")
    usuario = {"id": contador_id, "nome": nome, "email": email}
    usuarios.append(usuario)
    contador_id += 1
    return redirect("/")

# Editar usuário
@app.route("/editar/<int:id>")
def editar(id):
    usuario = next((u for u in usuarios if u["id"] == id), None)
    if usuario:
        return f"Editar usuário {usuario['nome']}"
    return "Usuário não encontrado", 404

# Excluir usuário
@app.route("/excluir/<int:id>")
def excluir(id):
    global usuarios
    usuarios = [u for u in usuarios if u["id"] != id]
    return redirect("/")

if __name__ == "__main__":
    app.run(debug=True)

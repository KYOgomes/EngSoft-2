import tkinter as tk
from tkinter import messagebox

def cadastrar_usuario():
    nome = entry_nome.get()
    telefone = entry_telefone.get()
    endereco = entry_endereco.get()

    if nome == '' or telefone == '' or endereco == '':
        messagebox.showerror('Erro', 'Por favor, preencha todos os campos.')
    else:
        # Gerar um ID único para o usuário
        if usuarios:
            proximo_id = max(usuario['ID'] for usuario in usuarios) + 1
        else:
            proximo_id = 1

        usuarios.append({'ID': proximo_id, 'Nome': nome, 'Telefone': telefone, 'Endereço': endereco})

        atualizar_lista_usuarios()

        entry_nome.delete(0, tk.END)
        entry_telefone.delete(0, tk.END)
        entry_endereco.delete(0, tk.END)

def editar_usuario():
    index = listbox_usuarios.curselection()
    if index:
        index = int(index[0])
        editar_janela = tk.Toplevel()
        editar_janela.title('Editar Usuário')

        usuario = usuarios[index]

        label_id = tk.Label(editar_janela, text='ID:')
        label_id.grid(row=0, column=0, padx=10, pady=5, sticky=tk.W)
        label_id_valor = tk.Label(editar_janela, text=usuario['ID'])
        label_id_valor.grid(row=0, column=1, padx=10, pady=5)

        label_nome = tk.Label(editar_janela, text='Nome:')
        label_nome.grid(row=1, column=0, padx=10, pady=5, sticky=tk.W)
        entry_nome_editar = tk.Entry(editar_janela)
        entry_nome_editar.insert(tk.END, usuario['Nome'])
        entry_nome_editar.grid(row=1, column=1, padx=10, pady=5)

        label_telefone = tk.Label(editar_janela, text='Telefone:')
        label_telefone.grid(row=2, column=0, padx=10, pady=5, sticky=tk.W)
        entry_telefone_editar = tk.Entry(editar_janela)
        entry_telefone_editar.insert(tk.END, usuario['Telefone'])
        entry_telefone_editar.grid(row=2, column=1, padx=10, pady=5)

        label_endereco = tk.Label(editar_janela, text='Endereço:')
        label_endereco.grid(row=3, column=0, padx=10, pady=5, sticky=tk.W)
        entry_endereco_editar = tk.Entry(editar_janela)
        entry_endereco_editar.insert(tk.END, usuario['Endereço'])
        entry_endereco_editar.grid(row=3, column=1, padx=10, pady=5)

        def salvar_edicao():
            usuarios[index] = {
                'ID': usuario['ID'],
                'Nome': entry_nome_editar.get(),
                'Telefone': entry_telefone_editar.get(),
                'Endereço': entry_endereco_editar.get()
            }
            atualizar_lista_usuarios()
            editar_janela.destroy()

        button_salvar = tk.Button(editar_janela, text='Salvar', command=salvar_edicao)
        button_salvar.grid(row=4, columnspan=2, padx=10, pady=10)

    else:
        messagebox.showerror('Erro', 'Por favor, selecione um usuário para editar.')

def excluir_usuario():
    index = listbox_usuarios.curselection()
    if index:
        index = int(index[0])
        usuario_id_excluido = usuarios[index]['ID']
        usuarios.pop(index)
        atualizar_lista_usuarios()
        
        # Atualizar IDs dos usuários após exclusão
        for usuario in usuarios:
            if usuario['ID'] > usuario_id_excluido:
                usuario['ID'] -= 1
    else:
        messagebox.showerror('Erro', 'Por favor, selecione um usuário para excluir.')

def atualizar_lista_usuarios():
    listbox_usuarios.delete(0, tk.END)
    for usuario in usuarios:
        id_usuario = usuario['ID']
        nome = usuario['Nome']
        telefone = usuario['Telefone']
        endereco = usuario['Endereço']
        listbox_usuarios.insert(tk.END, f'ID: {id_usuario}, Nome: {nome}, Telefone: {telefone}, Endereço: {endereco}')

root = tk.Tk()
root.title('Cadastro de Usuários')

usuarios = []

label_nome = tk.Label(root, text='Nome:')
label_nome.grid(row=0, column=0, padx=10, pady=5, sticky=tk.W)
entry_nome = tk.Entry(root)
entry_nome.grid(row=0, column=1, padx=10, pady=5)

label_telefone = tk.Label(root, text='Telefone:')
label_telefone.grid(row=1, column=0, padx=10, pady=5, sticky=tk.W)
entry_telefone = tk.Entry(root)
entry_telefone.grid(row=1, column=1, padx=10, pady=5)

label_endereco = tk.Label(root, text='Endereço:')
label_endereco.grid(row=2, column=0, padx=10, pady=5, sticky=tk.W)
entry_endereco = tk.Entry(root)
entry_endereco.grid(row=2, column=1, padx=10, pady=5)

button_cadastrar = tk.Button(root, text='Cadastrar', command=cadastrar_usuario)
button_cadastrar.grid(row=3, column=0, padx=10, pady=10, sticky=tk.W)

listbox_usuarios = tk.Listbox(root, width=70, height=15)
listbox_usuarios.grid(row=4, column=0, columnspan=2, padx=10, pady=5)

button_editar = tk.Button(root, text='Editar', command=editar_usuario)
button_editar.grid(row=5, column=0, padx=10, pady=10, sticky=tk.W)

button_excluir = tk.Button(root, text='Excluir', command=excluir_usuario)
button_excluir.grid(row=5, column=1, padx=10, pady=10, sticky=tk.E)

root.mainloop()

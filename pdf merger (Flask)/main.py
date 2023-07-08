from flask import Flask, request, render_template, session, send_file
from werkzeug.utils import secure_filename
import os
import uuid
import shutil
from PyPDF2 import PdfMerger
import io

app = Flask(__name__)
# app.secret_key = os.environ.get("FLASK_SECRET_KEY")
app.secret_key = "Test"
app.config['UPLOAD_FOLDER'] = 'temp' 


@app.route('/', methods=['GET', 'POST'])
def upload_file():
    """
    Gère l'accueil et l'envoi des fichiers
    """
    if request.method == 'POST':
        # Verifier s'il s'agit d'un POST suite a une selection de fichier
        if 'file' not in request.files:
            return render_template('index.html')

        # Récupérations des tout les fichiers séléctionné par l'utilisateur
        uploaded_files = request.files.getlist('file')
        # Les fichiers concervé sont ceux sui ont un nom valide non vide (à supprimer ?)
        uploaded_files = [uploaded_file for uploaded_file in uploaded_files if uploaded_file.filename]

        # S'il n'y a que des fichiers vides 
        if not uploaded_files:
            return render_template('index.html')

        # Si un utilisateur a déjà des fichiers sur le serveur, les fichiers sont supprimés
        if 'folder' in session:
            try:
                shutil.rmtree(os.path.join(app.config['UPLOAD_FOLDER'], session['folder']))
            except:
                pass

        # Création d'un nom de dossier aléatoire qui contiendra les fichiers uploadé par l'utilisateur
        session['folder'] = str(uuid.uuid4())
        user_folder_path = os.path.join(app.config['UPLOAD_FOLDER'], session['folder'])
        # Création du dossier de l'utilisateur
        os.mkdir(user_folder_path)

        # Tout les fichiers entrés par l'utilisateur sont sauvegardé dans le dossier temporaire.
        # Tout les noms de fichiers sont sécurisés
        for uploaded_file in uploaded_files:
            filename = secure_filename(uploaded_file.filename)
            uploaded_file.save(os.path.join(user_folder_path, filename))

        return render_template('uploaded_files.html', files=uploaded_files)

    return render_template('index.html')


@app.route('/download', methods=['POST'])
def download_file():
    """
    Gère la fusion des fichiers
    """
    # Récupération des données (il s'agit des noms de fichiers 
    # dans l'ordre de fusion choisis par l'utilisateur)
    data = request.json
    data = data['data']

    # Object qui va permettre d'assembler et de fusionner les fichiers
    merger = PdfMerger()

    user_folder_path = os.path.join(app.config['UPLOAD_FOLDER'], session['folder'])

    # Les fichiers ordonnées sont retrouvé dans le dossier de l'utilisateur, 
    # Dans l'ordre, les fichiers sont ajoutés au merger (pour ce faire, il a besoin du path de ses fichiers)
    # secure_file_name est utilisé car nous avons enregistré ces fichiers avec secure_file_name,
    # (le noms des fichiers ordonnées envoyés par l'utilisateur sont brut, il ont été laissé comme tel pour l'utilisateur)
    for file_name in data:
        file_name = secure_filename(file_name)
        merger.append(os.path.join(user_folder_path, file_name))

    # Création d'un dossier temporaire qui servira a stocker le resultat de la fusion des fichiers
    temp_dir_name = 'temp'
    os.mkdir(os.path.join(user_folder_path, temp_dir_name))

    # Création du fichiers fusionner, il est enregistré dans le dossier temportaire
    merged_file_path = os.path.join(user_folder_path, temp_dir_name, "result.pdf")
    merger.write(merged_file_path)
    merger.close()

    return_data = io.BytesIO()
    with open(merged_file_path, 'rb') as fo:
        return_data.write(fo.read())
    
    # Après avoir écrit, le curseur est a la fin, il est remis au début)
    return_data.seek(0)

    shutil.rmtree(user_folder_path)

    return send_file(return_data, mimetype='application/pdf')


if __name__ == '__main__':
    app.run(debug=True)
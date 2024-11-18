package com.example.profileapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializando componentes
        val profileImage = findViewById<ImageView>(R.id.profileImage)
        val nameText = findViewById<TextView>(R.id.nameText)
        val descriptionText = findViewById<TextView>(R.id.descriptionText)
        val currentJobText = findViewById<TextView>(R.id.currentJobText)
        val experienceLayout = findViewById<LinearLayout>(R.id.experienceLayout)
        val skillsLayout = findViewById<LinearLayout>(R.id.skillsLayout)
        val frameworkLayout = findViewById<LinearLayout>(R.id.frameworksLayout)

        // Definindo informações de perfil
        nameText.text = "Mariana Hofer"
        descriptionText.text = "22 anos, paulista e amante de T.I."
        currentJobText.text = "Analista de Projetos | Pesquisadora UX/UI"

        // Lista de experiências
        val experiencias = listOf(
            "Projeto Handle - Gestão, analista de resquisitos & UX/UI designer",
            "Pesquisadora UX - UFC",
            "FASTEF - Analista de Projetos & Requisitos"
        )

        // Lista de skills
        val skills = listOf(
            "Organizada",
            "Alto senso cooperativo",
            "Comunicativa"
        )

        // Lista de frameworks
        val frameworks = listOf(
            "Jira/Compliance",
            "Trello",
            "ClickUp",
            "Notion",
            "Power BI"
        )

        // Adicionando experiências dinamicamente
        for (experiencia in experiencias) {
            val textView = TextView(this)
            textView.text = experiencia
            textView.textSize = 16f
            experienceLayout.addView(textView)
        }

        // Adicionando skills dinamicamente
        for (skill in skills) {
            val textView = TextView(this)
            textView.text = skill
            textView.textSize = 16f
            skillsLayout.addView(textView)
        }

        // Adicionando frameworks dinamicamente
        for (framework in frameworks) {
            val textView = TextView(this)
            textView.text = framework
            textView.textSize = 16f
            frameworkLayout.addView(textView)
        }

        profileImage.setOnClickListener {
            Toast.makeText(this, "Foto de perfil de Mariana Hofer", Toast.LENGTH_SHORT).show()
        }

    }
}

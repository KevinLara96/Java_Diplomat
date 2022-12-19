<template>
  <v-app>
    <v-card
      class="mx-auto overflow-hidden"
      height="800"
      width="100%"
    >
      <v-app-bar
        color="blue darken-2"
        dense
        dark
      >
        <v-app-bar-nav-icon @click="drawer = true"></v-app-bar-nav-icon>

        <v-toolbar-title>Progamación PUMA</v-toolbar-title>
      </v-app-bar>
      <v-navigation-drawer
        v-model="drawer"
        absolute
        temporary
      >
        <v-list
          nav
          dense
        >
          <v-list-item-group
            v-model="group"
            active-class="deep-purple--text text--accent-4"
          >
            <v-list-item>
              <v-list-item-icon>
                <v-icon>mdi-home</v-icon>
              </v-list-item-icon>
              <v-list-item-title>Home</v-list-item-title>
            </v-list-item>

            <v-list-item>
              <v-list-item-icon>
                <v-icon>mdi-account</v-icon>
              </v-list-item-icon>
              <v-list-item-title>Account</v-list-item-title>
            </v-list-item>

            <v-list-item
              @click="reload()"
            >
              <v-list-item-icon>
                <v-icon>mdi-clipboard-list-outline</v-icon>
              </v-list-item-icon>
              <v-list-item-title>Excercises</v-list-item-title>
            </v-list-item>

            <v-list-item>
              <v-list-item-icon>
                <v-icon>mdi-logout-variant</v-icon>
              </v-list-item-icon>
              <v-list-item-title>LogOut</v-list-item-title>
            </v-list-item>
          </v-list-item-group>
        </v-list>
      </v-navigation-drawer>
      <v-card
        height="55"
        v-if="botones"
      >
        <v-row
          align="center"
          justify="space-around"
        >
          <v-btn
            height="50"
            width="50"
            @click="tabs = true"
          >
            <v-img
              max-height="50"
              max-width="50"
              src="..\src\img\c.png"
            ></v-img>
          </v-btn>
          <v-btn
            height="50"
            width="50"
            @click="tabs = true"
          >
            <v-img
              max-height="50"
              max-width="50"
              src="..\src\img\c++.jpg"
            ></v-img>
          </v-btn>
          <v-btn
            height="50"
            width="50"
            @click="tabs = true"
          >
            <v-img
              max-height="50"
              max-width="50"
              src="..\src\img\python.png"
            ></v-img>
          </v-btn>
          <v-btn
            height="50"
            width="50"
            @click="tabs = true"
          >
            <v-img
              max-height="50"
              max-width="50"
              src="..\src\img\node.png"
            ></v-img>
          </v-btn>
        </v-row>
      </v-card>
      <v-spacer></v-spacer>
      <v-card
        v-if="tabs"
        class="transition-fast-in-fast-out v-card--tabs"
      >
        <v-tabs
          background-color="blue-grey lighten-4"
          center-active
          dark
        >
          <v-tab @click="lista = true; lista_2 = false;">Objetos y Tipos de Datos</v-tab>
          <v-tab>Operadores</v-tab>
          <v-tab @click="lista_2 = true; lista = false;">Metodos y Funciones</v-tab>
          <v-tab>Orientado a Objetos</v-tab>
          <v-tab>Modulos y Paquetes</v-tab>
          <v-tab>Control de Errores</v-tab>
          <v-tab>Control de Excepciones</v-tab>
          <v-tab>Decoradores</v-tab>
          <v-tab>Generadores</v-tab>
          <v-tab>Programación Paralela</v-tab>
        </v-tabs>
      </v-card>
      <v-card
        v-if="lista"
        class="transition-fast-in-fast-out v-card--tabs mt-2"
      >
        <v-list dense>
          <v-subheader>Ejercicios</v-subheader>
          <v-list-item-group
            v-model="selectedItem"
            color="primary"
          >
            <v-list-item
              v-for="(item, i) in problems"
              :key="i"
            >
              <v-list-item-content>
                <v-list-item-title 
                  v-text="item.text"
                  @click="iframe = true; lista = false; tabs = false; botones = false"
                ></v-list-item-title>
              </v-list-item-content>
            </v-list-item>
          </v-list-item-group>
        </v-list>
      </v-card>

      <v-card
        v-if="lista_2"
        class="transition-fast-in-fast-out v-card--tabs mt-2"
      >
        <v-list dense>
          <v-subheader>Ejercicios</v-subheader>
          <v-list-item-group
            v-model="selectedItem"
            color="primary"
          >
            <v-list-item
              v-for="(item, i) in problems"
              :key="i"
            >
              <v-list-item-content>
                <v-list-item-title 
                  v-text="item.text_2"
                  @click="iframe_2 = true; lista_2 = false; tabs = false; botones = false"
                ></v-list-item-title>
              </v-list-item-content>
            </v-list-item>
          </v-list-item-group>
        </v-list>
      </v-card>

      <v-expand-transition>
        <v-card
          v-if="iframe"
          class="transition-fast-in-fast-out v-card--tabs"
          height="100%"
          width="100%"
        >
          <v-card-text>
            <iframe
              id="FrameID" 
              src="http://localhost/online-ide-master/ui/ide.html" 
              frameborder="0"
              width="1500"
              height="700"
            ></iframe>
          </v-card-text>
        </v-card>
      </v-expand-transition>

      <v-expand-transition>
        <v-card
          v-if="iframe_2"
          class="transition-fast-in-fast-out v-card--tabs"
          height="100%"
          width="100%"
        >
          <v-card-text>
            <iframe
              id="FrameID2" 
              src="http://localhost/online-ide-master_2/ui/ide.html" 
              frameborder="0"
              width="1500"
              height="700"
            ></iframe>
          </v-card-text>
        </v-card>
      </v-expand-transition>
    </v-card>
  </v-app>
</template>

<script>

export default {
  name: 'App',

  data: () => ({
    drawer: false,
    botones: true,
    group: null,
    tabs: false,
    lista: false,
    lista_2: false,
    iframe: false,
    iframe_2: false,
    items: [
      { language: 'C',},
      { language: 'C++',},
      { language: 'NodeJS',},
      { language: 'Python',},
    ],
    problems: [
      { text:'Numeros', text_2:'Maestro Yoda'},
      { text:'Asignación de variables', text_2:'Encuentra 33'},
      { text:'Cadenas', text_2:'Blackjack'},
      { text:'Impreción con formato', text_2:'Espia'},
      { text:'Listas', text_2:'Primos'},
      { text:'Diccionarios', text_2:'Imprime A Enorme'},
      { text:'Tuplas', text_2:'Pasea el perro'},
      { text:'Sets y booleanos', text_2:'Verano del 69'},
      { text:'Archivos', text_2:'Viejo MacDonald'},
    ]
  }),

  methods:{
    reload: function(){
      this.botones= true;
      this.iframe = false;
      this.iframe_2 = false;
    }
  }
};
</script>

<style>
.v-card--tabs {
  bottom: 0;
  opacity: 1 !important;
  position: absolute;
  width: 100%;
}
</style>
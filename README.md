# damm-core

Gemeinsame Quellen der Damm-Schul-Apps (DammBoard, DammTable, DammZeit, DammZahlen, DammLauncher).
Reiner Kotlin-Quellcode im neutralen Paket `de.oejendorferdamm.core`, als **Git-Submodul** in jede App
eingebunden (`core/`). So bleibt jede App ein eigenes, F-Droid-taugliches Repo mit eigenem Release –
die gemeinsamen Teile liegen nur einmal hier.

## Einbinden in eine App
```
git submodule add https://github.com/Teyro/damm-core.git core
```
In `app/build.gradle.kts` (im `android { }`-Block):
```
// Compose-App:
    sourceSets["main"].java.srcDirs("../core/src-core", "../core/src-compose")
    // App ohne Compose (nur gemeinsame Logik): nur
    // sourceSets["main"].java.srcDir("../core/src-core")
```
In den GitHub-Workflows beim Checkout `submodules: recursive` setzen.

## Inhalt
- `src-compose/m3/M3Einstellungen.kt` – Material-3-Einstellungsgerüst (EinstellungenThema, M3Kopf, M3Gruppe, M3Feld,
  M3Bereich, M3Schalter, M3Auswahl, M3Knopf, LokalEinstellungen). Braucht Compose + Material 3 in der App.

Weitere gemeinsame Teile (Update-Client/-Installer, Hintergrund-Job-Muster) kommen nach und nach dazu.

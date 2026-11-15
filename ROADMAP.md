# damm-core – Fahrplan

Ziel: die fünf Schul-Apps Stück für Stück auf eine gemeinsame, stabile, einheitliche Grundlage bringen –
ohne die getrennten Repos, Releases und F-Droid-Einträge aufzugeben.

## Erledigt
- Submodul-Struktur mit `src-core` (reines Kotlin) und `src-compose` (Material 3).
- **M3-Einstellungsgerüst** geteilt (DammZeit, DammZahlen, DammTable, DammBoard) – vorher viermal kopiert.
- **Versionsvergleich** geteilt (alle fünf Apps) – behebt den „-beta“-Unterschied, mit Test fürs Datumsschema.

## Als Nächstes (in dieser Reihenfolge)
1. **Update-Client vereinheitlichen.** Heute je App unterschiedlich (DammZahlen 160 Z., DammLauncher 237 Z.,
   DammBoard eigene `UpdateClient.kt`). Eine kanonische Fassung bauen: GitHub-Release abrufen, APK mit gleicher
   Signatur prüfen, herunterladen, installieren – Repo-Name und Paket je App als Parameter. **Vorsicht:** die
   7-Tage-Sicherheitssperre (Launcher) darf sich nicht ändern. Erst eine App umstellen, per CI prüfen, dann die anderen.
2. **Update-Installer** (`UpdateInstaller.kt`) teilen – DammZeit/DammTable sind fast identisch.
3. **Hintergrund-Jobs** (JobService-Muster für Abgleich/Update) vereinheitlichen.
4. **DammLauncher (Views)**: die `object M3`-Farbrollen und `dialogKnopf`/Material-Fenster ebenfalls nach
   `src-core` ziehen (ohne Compose), damit auch dort nur eine Quelle existiert.

## Stabilität & Performance (danach)
- Gemeinsamer Absturzschutz für alle JobServices (ein Muster, einmal gepflegt).
- Netz-Timeouts und Wiederholungen einheitlich.
- Bildspeicher/Leistungsmodus-Logik vergleichen und, wo sinnvoll, teilen.
- Ein gemeinsamer Satz Unit-Tests für die geteilten Teile (liegt bei den Apps, da damm-core kein Test-Harness hat).

## Grundregel
Jede Änderung an geteiltem Code nach `damm-core`, dann in jeder App das Submodul nachziehen und per CI bauen.
Nie eine App ohne grünen Build ausrollen.

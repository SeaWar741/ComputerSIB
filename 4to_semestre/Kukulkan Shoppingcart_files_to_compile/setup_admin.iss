; Script generated by the Inno Setup Script Wizard.
; SEE THE DOCUMENTATION FOR DETAILS ON CREATING INNO SETUP SCRIPT FILES!

[Setup]
; NOTE: The value of AppId uniquely identifies this application.
; Do not use the same AppId value in installers for other applications.
; (To generate a new GUID, click Tools | Generate GUID inside the IDE.)
AppId={{C129BB33-F667-4EC4-B191-EC323E58C83A}
AppName=ShoppingCart
AppVersion=1.0
;AppVerName=ShoppingCart 1.0
AppPublisher=Splashplayer
AppPublisherURL=https://www.facebook.com/splashplayer-238121522903898/?ref=br_rs
AppSupportURL=https://www.facebook.com/splashplayer-238121522903898/?ref=br_rs
AppUpdatesURL=https://www.facebook.com/splashplayer-238121522903898/?ref=br_rs
DefaultDirName={pf}\ShoppingCart
DisableProgramGroupPage=yes
OutputDir=C:\Users\Juan Ca\Desktop
OutputBaseFilename=Shoppingcart_setup
SetupIconFile=C:\Users\Juan Ca\Desktop\Kukulkan Shoppingcart\favicon.ico
Compression=lzma
SolidCompression=yes

[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"
Name: "spanish"; MessagesFile: "compiler:Languages\Spanish.isl"

[Tasks]
Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked

[Files]
Source: "C:\Users\Juan Ca\Desktop\Kukulkan Shoppingcart\ShoppingCart\shoppingcart.exe"; DestDir: "{app}"; Flags: ignoreversion
Source: "C:\Users\Juan Ca\Desktop\Kukulkan Shoppingcart\ShoppingCart\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs
; NOTE: Don't use "Flags: ignoreversion" on any shared system files

[Icons]
Name: "{commonprograms}\ShoppingCart"; Filename: "{app}\shoppingcart.exe"
Name: "{commondesktop}\ShoppingCart"; Filename: "{app}\shoppingcart.exe"; Tasks: desktopicon

[Run]
Filename: "{app}\shoppingcart.exe"; Description: "{cm:LaunchProgram,ShoppingCart}"; Flags: nowait postinstall skipifsilent

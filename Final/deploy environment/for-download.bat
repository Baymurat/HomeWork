bitsadmin  /transfer mydownloadjob  /download  /priority normal http://download.virtualbox.org/virtualbox/5.1.10/VirtualBox-5.1.10-112026-Win.exe  C:\Users\Admin\Downloads\vbinstall.exe
bitsadmin  /transfer mydownloadjob  /download  /priority normal https://releases.hashicorp.com/vagrant/1.9.1/vagrant_1.9.1.msi  C:\Users\Admin\Downloads\vagrant_install.msi
bitsadmin  /transfer mydownloadjob  /download  /priority normal https://github.com/git-for-windows/git/releases/download/v2.11.0.windows.1/Git-2.11.0-64-bit.exe  C:\Users\Admin\Downloads\git_install.exe
cd C:\Users\Admin\Downloads\
vbinstall.exe --silent
vagrant_install.msi /qb

package com.example.projekat1.view.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projekat1.model.Pacijent
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*

class PacijentViewModel : ViewModel() {

    private val pacijentListCekaonica : MutableList<Pacijent> = mutableListOf()
    private val pacijentListHospitalizovani : MutableList<Pacijent> = mutableListOf()
    private val pacijentListOtpusteni : MutableList<Pacijent> = mutableListOf()
    private val pacijentiCekaonice : MutableLiveData<List<Pacijent>> = MutableLiveData()
    private val pacijentiHospitalizacije : MutableLiveData<List<Pacijent>> = MutableLiveData()
    private val pacijentiOtpusteni : MutableLiveData<List<Pacijent>> = MutableLiveData()


    init {
        val sdf = SimpleDateFormat("M.dd.yyyy")
        val currentDate = sdf.format(Date())
        pacijentListCekaonica.add(
            Pacijent(
                "Nikola",
                "Nikolic",
                "Pacijent ima povisenu temperaturu i bolove u misicima",
                "Pacijent ima povisenu temperaturu i bolove u misicima",
                0,
                "https://thumbs.dreamstime.com/t/senior-man-sleeping-bed-morning-healthy-rest-recovery-time-senior-man-sleeping-bed-morning-healthy-rest-106271796.jpg",
                currentDate.toString()
            )
        )
        pacijentListCekaonica.add(
            Pacijent(
                "Petar",
                "Peric",
                "Pacijent ima bolove u misicima",
                "Pacijent ima bolove u misicima",
                4,
                "https://thumbs.dreamstime.com/t/senior-man-sleeping-bed-morning-healthy-rest-recovery-time-senior-man-sleeping-bed-morning-healthy-rest-106271796.jpg",
                currentDate.toString()
            )
        )
        pacijentListCekaonica.add(
            Pacijent(
                "Milos",
                "Milosevic",
                "Pacijent kaslje i ima bolove u plucima",
                "Pacijent kaslje i ima bolove u plucima",
                1,
                "https://thumbs.dreamstime.com/t/senior-man-sleeping-bed-morning-healthy-rest-recovery-time-senior-man-sleeping-bed-morning-healthy-rest-106271796.jpg",
                currentDate.toString()
            )
        )
        pacijentListCekaonica.add(
            Pacijent(
                "Lazar",
                "Lazic",
                "Pacijent ima povisenu temperaturu i upalu krajnika",
                "Pacijent ima povisenu temperaturu i upalu krajnika",
                2,
                "https://thumbs.dreamstime.com/t/senior-man-sleeping-bed-morning-healthy-rest-recovery-time-senior-man-sleeping-bed-morning-healthy-rest-106271796.jpg",
                currentDate.toString()
            )
        )
        pacijentListHospitalizovani.add(
            Pacijent(
                "Miodrag",
                "Miletic",
                "Pacijent ima jake bolove u stomaku",
                "Pacijent ima jake bolove u stomaku",
                3,
                "https://thumbs.dreamstime.com/t/senior-man-sleeping-bed-morning-healthy-rest-recovery-time-senior-man-sleeping-bed-morning-healthy-rest-106271796.jpg",
                currentDate.toString()
            )
        )
        pacijentListHospitalizovani.add(
            Pacijent(
                "Stefan",
                "Vasic",
                "Pacijent ima upalu grla",
                "Pacijent ima upalu grla",
                5,
                "https://thumbs.dreamstime.com/t/senior-man-sleeping-bed-morning-healthy-rest-recovery-time-senior-man-sleeping-bed-morning-healthy-rest-106271796.jpg",
                currentDate.toString()
            )
        )
        pacijentListOtpusteni.add(
            Pacijent(
                "Nemanja",
                "Nedeljkovic",
                "Pacijent ima migrenu",
                "Pacijent ima migrenu",
                6,
                "https://thumbs.dreamstime.com/t/senior-man-sleeping-bed-morning-healthy-rest-recovery-time-senior-man-sleeping-bed-morning-healthy-rest-106271796.jpg",
                currentDate.toString()
            )
        )
        pacijentListOtpusteni.add(
            Pacijent(
                "Svetozar",
                "Brankovic",
                "Pacijent je hronicki bolesnik",
                "Pacijent je hronicki bolesnik",
                7,
                "https://thumbs.dreamstime.com/t/senior-man-sleeping-bed-morning-healthy-rest-recovery-time-senior-man-sleeping-bed-morning-healthy-rest-106271796.jpg",
                currentDate.toString()
            )
        )
        pacijentListOtpusteni.add(
            Pacijent(
                "Relja",
                "Samardzic",
                "Pacijent se zali na jake bolove u ledjima",
                "Pacijent se zali na jake bolove u ledjima",
                8,
                "https://thumbs.dreamstime.com/t/senior-man-sleeping-bed-morning-healthy-rest-recovery-time-senior-man-sleeping-bed-morning-healthy-rest-106271796.jpg",
                currentDate.toString()
            )
        )
        pacijentiCekaonice.value = pacijentListCekaonica
        pacijentiHospitalizacije.value = pacijentListHospitalizovani
        pacijentiOtpusteni.value = pacijentListOtpusteni
    }

    fun updateRecord(pacijent: Pacijent){
        for(i in 0 until pacijentListHospitalizovani.size){
            if(pacijent.id == pacijentListHospitalizovani[i].id){
                pacijentListHospitalizovani[i].ime = pacijent.ime
                pacijentListHospitalizovani[i].prezime = pacijent.prezime
                pacijentListHospitalizovani[i].simptomiBolestiPriPrijemu = pacijent.simptomiBolestiPriPrijemu
                pacijentListHospitalizovani[i].simptomiBolestiTrenutno = pacijent.simptomiBolestiTrenutno
                break
            }
        }
        pacijentiHospitalizacije.value = pacijentListHospitalizovani
    }

    fun getPacijenteCekaonice() : LiveData<List<Pacijent>>{
        return pacijentiCekaonice
    }

    fun addHospitolize(patient: Pacijent){
        pacijentListCekaonica.remove(patient)
        pacijentiCekaonice.value =pacijentListCekaonica
        pacijentListHospitalizovani.add(patient)
        pacijentiHospitalizacije.value = pacijentListHospitalizovani

    }

    fun dodajUOtpust(patient: Pacijent){
        pacijentListHospitalizovani.remove(patient)
        pacijentiHospitalizacije.value =pacijentListHospitalizovani
        pacijentListOtpusteni.add(patient)
        pacijentiOtpusteni.value = pacijentListOtpusteni
    }

    fun getPacijenteHospitalizacije() : LiveData<List<Pacijent>>{
        return pacijentiHospitalizacije
    }

    fun getPacijenteOtpustene() : LiveData<List<Pacijent>>{
        return pacijentiOtpusteni
    }

    fun addPacijent(patient: Pacijent){
        pacijentListCekaonica.add(patient)
        pacijentiCekaonice.value = pacijentListCekaonica
    }

    fun removePacijent(patient: Pacijent){
        pacijentListCekaonica.remove(patient)
        pacijentiCekaonice.value =pacijentListCekaonica
    }

    fun filterPacijentCekaonica(filter : String){
        val filterList = pacijentListCekaonica.filter {
            it.ime.toLowerCase().contains(filter.toLowerCase()) ||
            it.prezime.toLowerCase().contains(filter.toLowerCase())
        }
        pacijentiCekaonice.value = filterList
    }

    fun filterPacijentHospitalizovani(filter : String){
        val filterList = pacijentListHospitalizovani.filter {
            it.ime.toLowerCase().contains(filter.toLowerCase()) ||
                    it.prezime.toLowerCase().contains(filter.toLowerCase())
        }
        pacijentiHospitalizacije.value = filterList
    }

    fun filterPacijentOtpusteni(filter : String){
        val filterList = pacijentListOtpusteni.filter {
            it.ime.toLowerCase().contains(filter.toLowerCase()) ||
                    it.prezime.toLowerCase().contains(filter.toLowerCase())
        }
        pacijentiOtpusteni.value = filterList
    }

    fun brojCekaonica() : Int {
        return pacijentListCekaonica.size
    }

    fun brojHospitalizacija() : Int {
        return pacijentListHospitalizovani.size
    }

    fun brojOtpusteni() : Int {
        return pacijentListOtpusteni.size
    }

}
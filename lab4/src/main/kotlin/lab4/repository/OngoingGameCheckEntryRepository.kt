package lab4.repository

import lab4.model.OngoingGame
import lab4.model.OngoingGameCheckEntry
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.transaction.annotation.Transactional

interface OngoingGameCheckEntryRepository : JpaRepository<OngoingGameCheckEntry, Long> {
    @Transactional
    fun deleteAllByOngoingGame(ongoingGame: OngoingGame)

    fun findAllByOngoingGame(ongoingGame: OngoingGame): List<OngoingGameCheckEntry>

}
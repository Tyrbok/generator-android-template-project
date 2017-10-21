package <%= packageName %>.application

import io.reactivex.Single
import <%= packageName %>.domain.StarterData
import <%= packageName %>.domain.StarterDataRepository

class GetStarterData(private val starterDataRepository: StarterDataRepository) {

    fun execute(): Single<String> {
        return starterDataRepository
                .get()
                .map(StarterData::message)
    }
}

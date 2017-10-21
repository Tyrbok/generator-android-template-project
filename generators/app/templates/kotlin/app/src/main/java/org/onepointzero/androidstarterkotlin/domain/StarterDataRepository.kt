package <%= packageName %>.domain

import io.reactivex.Single

interface StarterDataRepository {
    fun get(): Single<StarterData>
}

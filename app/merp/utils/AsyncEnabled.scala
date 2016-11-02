package merp.utils

import javax.inject.Inject
import merp.business.utils.ExecutionContexts

abstract class AsyncEnabled @Inject() (ec: ExecutionContexts)
<div class="modal visits_add_modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">.

            <form method="post" action="visits-add.action">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Add new visit</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <div class="form-group">
                            <label>Complaints: <input type="text" required class="form-control" name="visit.complaints"></label>
                        </div>
                        <div class="form-group">
                            <label>Diagnosys: <input type="text" required  class="form-control" name="visit.diagnosys"></label>
                        </div>
                        <div class="form-group">
                            <label>Medical history id: <input type="number" required min="1" class="form-control" name="visit.medicalHistoryId"></label>
                        </div>
                        <div class="form-group">
                            <label>Order id: <input type="number" required min="1" class="form-control" name="visit.orderId"></label>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary add-btn">Save</button>
                    </div>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
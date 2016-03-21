<div class="modal visits_edit_modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">.

            <form method="post" action="/update.action">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Update visit info</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <input id="visits_edit_id" name="visit.id" type="hidden">
                        <div class="form-group">
                            <label>Id treatment: <input type="number" class="form-control" name="visit.idTreatment"></label>
                        </div>
                        <div class="form-group">
                            <label>Id medical history: <input type="number" class="form-control" name="visit.idMedicalHistory"></label>
                        </div>
                        <div class="form-group">
                            <label>Id order: <input type="number" class="form-control" name="visit.idOrder"></label>
                        </div>
                        <div class="form-group">
                            <label>Diagnosis: <input type="text" class="form-control" name="visit.diagnosis"></label>
                        </div>
                        <div class="form-group">
                            <label>Complaints: <input type="text" class="form-control" name="visit.complaints"></label>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary add-btn">Save changes</button>
                    </div>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div class="modal medical_histories_edit_modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">.

            <form method="post" action="medical-histories-update.action">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Update medical history info</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <input id="medical_histories_edit_id" name="medicalHistory.id" type="hidden">
                        <div class="form-group">
                            <label>Client id: <input type="number" class="form-control" name="medicalHistory.clientId"></label>
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
